package sn.isi.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.isi.dto.Facture;
import sn.isi.service.FactureService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/factures")
@AllArgsConstructor
public class FactureController {

    private FactureService factureService;

    @GetMapping
    public List<Facture> getFacture() {
        return factureService.getFactures();
    }

    @GetMapping("/{id}")
    public Facture getFacture(@PathVariable("id") int id) {
        return factureService.getFacture(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Facture createAppFactures(@Valid @RequestBody Facture facture) {
        return factureService.createFacture(facture);
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable("id") int id, @Valid @RequestBody Facture facture) {
        return factureService.updateFacture(id, facture);
    }

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable("id") int id)  {factureService.deleteFactures(id);}

}
