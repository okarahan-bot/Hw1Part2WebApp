package Hw1Part2WebApp;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.port;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {
    public static boolean searchForSumOfNums(ArrayList<Integer> list, Integer number1, Integer number2, Integer number3) {
        int sum = number1 + number2 + number3;
        if (list == null || list.size() == 0 || number1 < 0 || number2 < 0 || number3 < 0) {
            return false;
        }

        for (int element : list) {
            if (element < 0) {
                return false;
            }

            if (element == sum) { 
              return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.getName());

        int port = Integer.parseInt(System.getenv("PORT"));
        port(port);
        logger.severe("Current port number:" + port);

        get("/", (req, res) -> "Welcome To My BIL481 Web App Homework!");

        post("/compute", (req, res) -> {
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext()) {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          sc1.close();

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);

          String input4 = req.queryParams("input4").replaceAll("\\s","");
          int input4AsInt = Integer.parseInt(input4);

          boolean result = App.searchForSumOfNums(inputList, input2AsInt, input3AsInt, input4AsInt);

          Map<String, Boolean> map = new HashMap<String, Boolean>();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map<String, String> map = new HashMap<String, String>();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
   }
}