/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.donor.darah.crud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author whildan fajar
 */

@RestController
@RequestMapping(value = "/datadonor")
public class DonorController {
    @Autowired
    RepositoryDonor repositoryDonor;
    
    //Tambah pendonor darah
    @PostMapping(value = "/addnewdonor")
    public Donor addnewdonor(@RequestBody Donor param)
    {
        repositoryDonor.save(param);
        return param;
    }  

    //Melihat semua data pendonor darah
    @GetMapping(value = "/getalldonor")

    public List<Donor> getalldonor()
    {
        return repositoryDonor.findAll();
    }

    //Edit data pendonor
    @PutMapping(value = "/updatedonor")

    public Donor updatedonor(@RequestBody Donor param)
    {
        return repositoryDonor.save(param);
    }

    //delete data pendonor
    @DeleteMapping(value = "/deletemhs")

    public List <Donor> deletemhs(@RequestParam String nik)
    {
        repositoryDonor.deleteById(nik);
        List<Donor> donorlist = repositoryDonor.findAll();
        return donorlist;
    }
    
    
    
//    @GetMapping(value = "/getdonorbyid")
//
//    public Donor getdonorbyid(@RequestParam int nik)
//    {
//        return repositoryDonor.findById(nik).get();
//    }

}
