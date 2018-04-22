package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Actor;
import kz.kaznitu.lessons.models.Kino;
import kz.kaznitu.lessons.models.Rejisser;
import kz.kaznitu.lessons.repositories.KinoRepository;
import kz.kaznitu.lessons.repositories.ActorRepository;
import kz.kaznitu.lessons.repositories.RejisserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FightersController {
    @Autowired
    private KinoRepository kinoRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private RejisserRepository rejisserRepository;

    @RequestMapping("/kino/{id}")
    public String Kino(@PathVariable("id")int id, Model model){
        model.addAttribute("kino", kinoRepository.findById(id).get());
        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("rejissers", rejisserRepository.findAll());
        return "kino";
    }

    @RequestMapping(value = "/kinos",method = RequestMethod.GET)
    public String kinosList(Model model){
        model.addAttribute("kinos", kinoRepository.findAll());
        return "kinos";
    }
    @RequestMapping(value = "/kinos",method = RequestMethod.POST)
    public String KinosAdd(@RequestParam String name,
                                @RequestParam String strana,
                                @RequestParam String zhanr,
                                @RequestParam Integer god,
                                Model model){
        Kino newKino = new Kino();
        newKino.setName(name);
        newKino.setStrana(strana);
        newKino.setZhanr(zhanr);
        newKino.setGod(god);
        kinoRepository.save(newKino);

        model.addAttribute("kinos", newKino);
        model.addAttribute("actors", actorRepository.findAll());
        model.addAttribute("rejissers", rejisserRepository.findAll());
        return "redirect:/kino/" + newKino.getId();
    }

    @RequestMapping(value = "/kino/{id}/actors", method = RequestMethod.POST)
    public String fightersAddSkill(@PathVariable Integer id,
                                     @RequestParam Integer actorId,
                                     Model model) {
        Actor actor = actorRepository.findById(actorId).get();
        Kino kino = kinoRepository.findById(id).get();



        if(kino != null){
            if(!kino.hasActor(actor)){
                kino.getActors().add(actor);
            }

            kinoRepository.save(kino);
            model.addAttribute("kino", kinoRepository.findById(id).get());
            model.addAttribute("actors", actorRepository.findAll());

            return "redirect:/kino/" + kino.getId();
        }

        model.addAttribute("kinos", kinoRepository.findAll());
        return "redirect:/kinos";
    }


    @RequestMapping(value = "/kino/{id}/rejissers", method = RequestMethod.POST)
    public String fightersAddSkil(@PathVariable Integer id,
                                   @RequestParam Integer rejisserId,
                                   Model model) {
        Rejisser rejisser = rejisserRepository.findById(rejisserId).get();
        Kino kino = kinoRepository.findById(id).get();

        if(kino != null){

            if(!kino.hasRejisser(rejisser)){
                kino.getRejissers().add(rejisser);
            }

            kinoRepository.save(kino);
            model.addAttribute("kino", kinoRepository.findById(id).get());
            model.addAttribute("rejissers", rejisserRepository.findAll());
            return "redirect:/kino/" + kino.getId();
        }

        model.addAttribute("kinos", kinoRepository.findAll());
        return "redirect:/kinos";
    }



    @RequestMapping(value = "/actors",method = RequestMethod.GET)
    public String actorsAdd(Model model){
        model.addAttribute("actor",new Actor());
        return "actors";
    }
    @RequestMapping(value = "/actors", method = RequestMethod.POST)
    public String actorsAdd(@ModelAttribute Actor actor){
        actorRepository.save(actor);
        return "redirect:/kinos";
    }

    @RequestMapping(value = "/rejissers",method = RequestMethod.GET)
    public String rejissersAdd(Model model){
        model.addAttribute("rejisser",new Rejisser());
        return "rejissers";
    }
    @RequestMapping(value = "/rejissers", method = RequestMethod.POST)
    public String rejissersAdd(@ModelAttribute Rejisser rejisser){
        rejisserRepository.save(rejisser);
        return "redirect:/kinos";
    }

}
