package com.java.example.mojo;

import com.java.example.utils.FindTheNumberOfPalindromeClasses;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import java.util.List;

//mvn com.java.example:example-maven-plugin:run
@Mojo(name = "run", defaultPhase = LifecyclePhase.INITIALIZE)
public class MojoFindTheNumberOfPalindromeClasses extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;
    String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\java\\example\\myClasses";

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        //Call the FindTheNumberOfPalindromeClasses for using this class methods
        FindTheNumberOfPalindromeClasses names = new FindTheNumberOfPalindromeClasses(path);
        List<String> list = names.getList();
        int numberOfClasses = names.getNumberOfClasses();
        int numberOfPalindromeClasses = names.getNumberOfPalindromeClasses();
        int numberOfNonPalindromeClasses = numberOfClasses - numberOfPalindromeClasses;

        //Log to terminal results
        getLog().info("* Name of classes: ");
        for(String name:list){
            getLog().info(name);
        }
        getLog().info("* Number of classes: "+numberOfClasses);
        getLog().info("* Number of palindrome classes: "+numberOfPalindromeClasses);
        getLog().info("* Number of nonPalindrome classes: "+numberOfNonPalindromeClasses);

    }
}
