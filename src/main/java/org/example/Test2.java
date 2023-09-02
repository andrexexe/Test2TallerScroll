package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nuevo\\IdeaProjects\\Test2\\src\\main\\resources\\chromedriver.exe");


        //Arancar el navegador
        WebDriver driver = new ChromeDriver();

        //Abrir pagina
        driver.get("https://www.saucedemo.com/v1/");

        //Maximizar
        driver.manage().window().maximize();

        //Variables (Guardar credenciales)
        String usuario = "standard_user";
        String password = "secret_sauce";

        //Localizar elementos por ID
        WebElement user = driver.findElement(By.id("user-name"));
        WebElement pass = driver.findElement(By.id("password"));

        //Localizar por Xpath
        WebElement btnlogin = driver.findElement(By.xpath("//input[@id='login-button']"));

        //Hacer Login
        user.sendKeys(usuario);
        pass.sendKeys(password);
        btnlogin.click();

        // Realizar scroll usando JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Agregar productos al carrito
        WebElement btnAgregarMaleta = driver.findElement(By.xpath("//div[@class='inventory_list']/div[1]//button[@class='btn_primary btn_inventory']"));
        btnAgregarMaleta.click();

        WebElement btnAgregarCamiseta = driver.findElement(By.xpath("//div[@class='inventory_list']/div[3]//button[@class='btn_primary btn_inventory']"));
        btnAgregarCamiseta.click();
        WebElement btnAgregarCamisa = driver.findElement(By.xpath("//div[6]//button[@class='btn_primary btn_inventory']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", btnAgregarCamisa);
        btnAgregarCamisa.click();
        //Ver carrito
        WebElement btnCarrito = driver.findElement(By.cssSelector("path"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", btnCarrito);
        btnCarrito.click();

        //Confirmar compra
        WebElement btnConfirmar = driver.findElement(By.xpath("//a[.='CHECKOUT']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", btnConfirmar);
        btnConfirmar.click();

        //Completar Datos - variables
        String nombre = "Andres";
        String apellido = "Mendez";
        String codigoPostal = "250001";

        //Localizar elementos
        WebElement name = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement codPostal = driver.findElement(By.id("postal-code"));
        WebElement btncontinuar = driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));

        //Completar datos
        name.sendKeys(nombre);
        lastName.sendKeys(apellido);
        codPostal.sendKeys(codigoPostal);
        btncontinuar.click();
        //Finalizar compra
        WebElement btnfinalizar = driver.findElement(By.xpath("//a[.='FINISH']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", btnfinalizar);
        btnfinalizar.click();

        //Scroll hacia abajo-arriba
        jsExecutor.executeScript("window.scrollBy(0, 500);");
        jsExecutor.executeScript("window.scrollBy(0, -250);");




    }


}
