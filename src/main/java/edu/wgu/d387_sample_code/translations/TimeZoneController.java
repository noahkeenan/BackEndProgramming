package edu.wgu.d387_sample_code.translations;

import edu.wgu.d387_sample_code.translations.TimeZoneConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TimeZoneController {

    @GetMapping("/convertTime")
    public String getConvertedTime(@RequestParam String time) {
        return TimeZoneConverter.convertTime(time);
    }
}