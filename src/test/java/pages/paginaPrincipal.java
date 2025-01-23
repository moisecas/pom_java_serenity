package pages;


public class paginaPrincipal extends basePage{
    public paginaPrincipal() {
        super(driver);
    }

    private String appleButton = "//span[normalize-space()='%s']";
    private String btnSignIn = "//span[@id='signin']";



    // Método para navegar a www.bstackdemo.com
    public void navigateToBrowserStack() {
        navigateTo("https://www.bstackdemo.com");
        
    }

    public void clickOnMarks(String section){
        //reemplaza el marcador de posicion con el nombre
        String xpacthSection = String.format(appleButton, section);
        clickElement(xpacthSection);
    }

    public void clickSignIn(){
       clickElement(btnSignIn);
    }
    

}


