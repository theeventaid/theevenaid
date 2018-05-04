package com.tgj.eventaid.components;

import com.uber.sdk.core.auth.OAuth2Credentials;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.core.auth.internal.OAuth2Service;
import com.uber.sdk.core.client.CredentialsSession;
import com.uber.sdk.core.client.ServerTokenSession;
import com.uber.sdk.core.client.SessionConfiguration;
import com.uber.sdk.rides.client.UberRidesApi;
import com.uber.sdk.rides.client.error.ApiError;
import com.uber.sdk.rides.client.error.ClientError;
import com.uber.sdk.rides.client.error.ErrorParser;
import com.uber.sdk.rides.client.model.RideEstimate;
import com.uber.sdk.rides.client.model.TimeEstimate;
import com.uber.sdk.rides.client.model.TimeEstimatesResponse;
import com.uber.sdk.rides.client.services.RidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UberComponent {

    private final SessionConfiguration config;
    private final RidesService ridesService;
    private final String clientId, clientSecret;

    @Autowired
    public UberComponent(@Value("${uber.client.id}") String clientId,
                         @Value("${uber.client.secret}") String clientSecret) throws UnsupportedEncodingException {

        this.clientId = clientId;
        this.clientSecret = clientSecret;

        List<Scope> scopes = new ArrayList<>();
        scopes.add(Scope.REQUEST);

        config = new SessionConfiguration.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setEnvironment(SessionConfiguration.Environment.SANDBOX)
                .setScopes(scopes)
                .setRedirectUri("http://localhost/")
                .build();

        OAuth2Credentials credentials = new OAuth2Credentials.Builder().setSessionConfiguration(config).build();
        String authUrl = credentials.getAuthorizationUrl();
//        Credential credential = credentials.authenticate(au)
        CredentialsSession session = new CredentialsSession(config, credentials);

//        this.ridesService = UberRidesApi.with(session).build().createService();
    }

    public void getRideTimeEstimate() throws IOException {
        Response<TimeEstimatesResponse> response = ridesService.getPickupTimeEstimate(37.79f, -122.39f, null).execute();
        if (response.isSuccessful()) {
            List<TimeEstimate> times = response.body().getTimes();
            System.out.println(Arrays.toString(times.toArray()));
        } else {
            ApiError error = ErrorParser.parseError(response);
            List<ClientError> clientErrors = error.getClientErrors();
            for (ClientError e : clientErrors) {
                System.out.println(e.getTitle());
            }
        }
    }
}