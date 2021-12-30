package fr.lernejo.travelsite.controller;
import fr.lernejo.travelsite.controller.record.Inscription;
import fr.lernejo.travelsite.controller.record.Travels;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(value="/api")
public class LauncherController {
    private final List<Inscription> liste1 = new ArrayList<>();
    private final List<Travels> liste2 = new ArrayList<>();
    @PostMapping("/inscription")
    public void AddList(@RequestBody Inscription body){
        this.liste1.add(body);
    }
    @GetMapping("/travels")
    public List<Travels> AddList(@RequestParam String userName) {
        liste2.add(new Travels("Caribbean",10));
        liste2.add(new Travels("Australia",10));
        return liste2;
    }
    @GetMapping("/inscription")
    public List<Inscription> SendList() {
        return liste1;
    }
}
