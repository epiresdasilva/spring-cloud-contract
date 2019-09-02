package br.com.sabino;

import au.com.dius.pact.model.Interaction;
import au.com.dius.pact.model.v3.messaging.Message;
import au.com.dius.pact.provider.IConsumerInfo;
import au.com.dius.pact.provider.IProviderInfo;
import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.ProviderVerifier;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomProviderVerifier extends ProviderVerifier {

    private List<String> packagesToScan;

    public CustomProviderVerifier(List<String> packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    @Override
    public boolean verifyResponseByInvokingProviderMethods(@NotNull IProviderInfo providerInfo, @NotNull IConsumerInfo consumer, @NotNull Interaction interaction, @NotNull String interactionMessage, @NotNull Map<String, Object> failures) {
        try {

            ConfigurationBuilder configurationBuilder = new ConfigurationBuilder()
                    .setScanners(new MethodAnnotationsScanner())
                    .forPackages(packagesToScan.toArray(new String[]{}));

            Reflections reflections = new Reflections(configurationBuilder);
            Set<Method> methodsAnnotatedWith = reflections.getMethodsAnnotatedWith(PactVerifyProvider.class);
            Set<Method> providerMethods = methodsAnnotatedWith.stream()
                    .filter(m -> {
                        PactVerifyProvider annotation = m.getAnnotation(PactVerifyProvider.class);
                        return annotation.value().equals(((Interaction) interaction).getDescription());
                    })
                    .collect(Collectors.toSet());

            if (providerMethods.isEmpty()) {
                throw new RuntimeException("No annotated methods were found for interaction " +
                        "'${interaction.description}'. You need to provide a method annotated with " +
                        "@PactVerifyProvider(\"${interaction.description}\") that returns the message contents.");
            } else {
                if (interaction instanceof Message) {
                    verifyMessagePact(providerMethods, (Message) interaction, interactionMessage, failures);
                } else {
                    throw new RuntimeException("only supports Message interactions!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("verification failed", e);
        }
        return true;
    }

}