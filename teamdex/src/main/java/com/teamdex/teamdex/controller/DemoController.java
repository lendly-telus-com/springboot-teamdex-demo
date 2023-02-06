package com.teamdex.teamdex.controller;

import org.springframework.web.bind.annotation.RestController;

import com.teamdex.teamdex.entity.DemoModel;
import com.teamdex.teamdex.service.DemoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/v1")
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/artists")
    public List<DemoModel> findall() {
        return this.demoService.findall();

    }

    @PostMapping("/artists")
    public Optional<DemoModel> saveModel(@RequestBody DemoModel demoModel) {
        return this.demoService.saveModel(demoModel);

    }

    @PutMapping("/artists/{id}")
    public DemoModel updateArtistsById(@PathVariable(value = "id") Long id, @RequestBody DemoModel demoModel) {
        return demoService.updateArtistsById(id, demoModel);
    }

    @DeleteMapping("/artists/{id}")
    public String deleteArtists(@PathVariable(value = "id") Long id) {
        return demoService.deleteArtists(id) + " artist id # " + id;
    }

}
