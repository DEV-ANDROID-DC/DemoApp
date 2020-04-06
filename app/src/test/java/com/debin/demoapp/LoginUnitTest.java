package com.debin.demoapp;

import android.content.Context;

import com.debin.demoapp.data.FakeServer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    public static final String FAKE_SUCCESS_MESSAGE = "Login Success";
    public static final String FAKE_FAIL_MESSAGE = "Login failed";

    FakeServer fakeServer = new FakeServer();


    @Mock
    Context mMockContext;


    @Test
    public void ValidateUserWithValidCredentials() {
           fakeServer.registerUser("debin","debin");
           String userName = "debin";
           String password = "debin";
           String result;
           if(fakeServer.getUserName().equals(userName) &&
              fakeServer.getPassword().equals(password)) {
               result = "Login Success";
           } else {
               result = "Invalid user";
           }
           assertThat(result, is(FAKE_SUCCESS_MESSAGE));

    }

    @Test
    public void ValidateUserWithInvalidCredentials() {
        fakeServer.registerUser("debin","debin123");
        String userName = "debin";
        String password = "debin";
        String result;
        if(fakeServer.getUserName().equals(userName) &&
                fakeServer.getPassword().equals(password)) {
            result = "Login Success";
        } else {
            result = "Login failed";
        }
        assertThat(result, is(FAKE_FAIL_MESSAGE));
    }
}
