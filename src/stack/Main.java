package stack;

import java.util.Stack;
import org.json.simple.JSONObject;

public class Main {
    Options options=new Options();
    static Stack <JSONObject>backStack=new Stack<>();
    Main(){
        backStack.push((JSONObject)options.getFirstPage());
    }

    public static void main(String[] args) {
        new Main().start();
    }

    public void start(){
        while(true){
            options.printOptions();
            long id=options.getChoice();
            if(id==0){
                return;
            }
            else if(id==-1){
                goBack();
            }
            else if(id==-2){
                goBackToMainPage();
            }else{
                goToPage();
            }
        }
    }
    // Go To next page
    public void goToPage() {
        JSONObject page=(JSONObject)options.getCurrentObj();
        backStack.push(page);
    }
    // Go Back one page
    public void goBack(){
        backStack.pop();
        JSONObject page=(JSONObject)backStack.pop();
        options.setCurrentObj(page);
    }
    // Go back to main page
    public void goBackToMainPage(){
        backStack.clear();
        JSONObject page=(JSONObject)options.getFirstPage();
        backStack.push(page);
        options.setCurrentObj(page);
    }
}
