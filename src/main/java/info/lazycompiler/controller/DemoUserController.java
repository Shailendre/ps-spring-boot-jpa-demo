package info.lazycompiler.controller;

import info.lazycompiler.model.DemoUser;
import info.lazycompiler.repository.DemoUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class DemoUserController {

    @Autowired
    private DemoUserRepository demoUserRepository;

    @RequestMapping(
            path = "/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String add(@RequestBody DemoUser demoUser) {
        DemoUser user = demoUserRepository.save(demoUser);
        return  String.valueOf(user.getId());
    }


    @RequestMapping(
            path = "/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DemoUser get(@PathVariable long id) {
         return demoUserRepository.findById(id)
                 .orElse(null);
    }


    @RequestMapping(
            path = "/update/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DemoUser update(@PathVariable long id, @RequestBody DemoUser demoUser) {
        DemoUser existingDemoUser = demoUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        DemoUser updatedUser = new DemoUser();
        BeanUtils.copyProperties(existingDemoUser, updatedUser);
        demoUserRepository.saveAndFlush(updatedUser);
        return updatedUser;
    }


    @RequestMapping(
            path = "/delete/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DemoUser delete(@PathVariable long id) {
        DemoUser deleteUser = demoUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        demoUserRepository.delete(deleteUser);
        return deleteUser;
    }

}
