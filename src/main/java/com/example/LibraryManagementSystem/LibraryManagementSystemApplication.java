package com.example.LibraryManagementSystem;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	private static final String UID = "some-uid";
	public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
		FileInputStream serviceAccount =
				new FileInputStream("./serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);
		String customToken = FirebaseAuth.getInstance().createCustomTokenAsync(UID).get();
		System.out.println(customToken);

		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

}
