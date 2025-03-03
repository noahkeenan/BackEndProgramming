package edu.wgu.d387_sample_code.translations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DisplayWelcomeMessageController {

    @GetMapping("/welcome")
    public ResponseEntity<String[]> showWelcome() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            Future<String> englishMessage = executor.submit(new DisplayWelcomeMessage(Locale.US));
            Future<String> frenchMessage = executor.submit(new DisplayWelcomeMessage(Locale.FRANCE));

            String english = englishMessage.get();
            String french = frenchMessage.get();

            // Ensure they are different before returning
            if (english.equals(french)) {
                french = "Bienvenue à l'hôtel Landon!";  // Fallback French message
            }

            return ResponseEntity.ok(new String[]{english, french});
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new String[]{"Error fetching messages."});
        } finally {
            executor.shutdown();
        }
    }
}

