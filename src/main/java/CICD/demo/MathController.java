package CICD.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/math")
public class MathController
{
    @GetMapping(value = "/mult")
public Integer  Mult( @RequestBody DataModel dataModel)
{
    return dataModel.x * dataModel.y ;
}

    @GetMapping(value = "/add")
    public Integer Add( )
    {
        return 1212;
    }


}
