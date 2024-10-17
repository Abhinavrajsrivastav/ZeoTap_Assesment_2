package com.example.abhinav.whether.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.abhinav.whether.Entity.Whether;
import com.example.abhinav.whether.Entity.Service.SeeService;



@RestController
public class WheterController {
 
    //Dependency Injection..
    @Autowired
    SeeService seeService;

    //Difining end point - of /wheteherApp - GET...
    @GetMapping("/wheteherApp")
    public ModelAndView sendModelAndView() {
        String view = "wheteherApp";
        Map<String, Object> model = new HashMap<>();
        Whether whether = new Whether();
        model.put("whetherObject", whether);

        //returning a model(data) to the view("wheteherApp.html")...
        return new ModelAndView(view, model);
    }
    
    //Difining end point - of /wheteherApp - POST...
   @PostMapping("/wheteherApp")
   public ModelAndView processForm(@ModelAttribute("whetherObject") Whether whether) {
    try {
        // Get current weather data as a String array...
        String[] data = seeService.getWeather(whether.getName());

        // Get forecast data as a 2D array...
        String[][] fdata = seeService.getForecast(whether.getName());

        // Prepare the model with both data and fdata...
        Map<String, Object> model = new HashMap<>();
        model.put("data", data);         // Current weather data
        model.put("fdata", fdata);       // Forecast data

        // Return the model to the view "resultPage.html"
        return new ModelAndView("resultPage", model);
} 
        catch (Exception e) {
        e.printStackTrace();
        // Return error page with an error message in case of exception
        return new ModelAndView("errorPage", "errorMessage", "Error getting weather information");
    }
}
}
