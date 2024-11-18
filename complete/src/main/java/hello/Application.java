package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return """
                <html>
                    <body>
                        <form action="/calculate" method="post">
                            <label for="expression">Enter Expression:</label>
                            <input type="text" id="expression" name="expression" placeholder="e.g., 2+2*2" />
                            <button type="submit">Calculate</button>
                        </form>
                    </body>
                </html>
               """;
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String expression) {
        try {
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();

            return """
                    <html>
                        <body>
                            <p>Result: %f</p>
                            <a href="/">Back</a>
                        </body>
                    </html>
                   """.formatted(result);
        } catch (Exception e) {
            return """
                    <html>
                        <body>
                            <p>Error: Invalid expression!</p>
                            <a href="/">Back</a>
                        </body>
                    </html>
                   """;
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
