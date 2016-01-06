package com.prdioliveira.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Paulo on 24/09/2015.
 */
public class IndustriasFiemg {
    WebDriver driver = null;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void pegarDados()throws InterruptedException{
        File caminhoArquivoEntrada = new File ("C:/temp/urls_em_andamento.txt");

        File caminhoSaida = new File ("C:/temp/listaDados.txt");
        String linha;

        try {
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoEntrada));
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoSaida));
            while(br.ready()){
                linha = br.readLine();
                WebDriverWait wait = new WebDriverWait(driver, 20);

                driver.navigate().to("http://www.cadastroindustrialmg.com.br/Empresas/" + linha);
                driver.manage().window().maximize();
                try{
                    WebElement div = driver.findElement(By.xpath(".//*[@id='divNv']/div"));

                    WebElement divDadosEmpresa = driver.findElement(By.xpath(".//*[@id='divNv']/div"));

                    WebElement nm_empresa = driver.findElement(By.xpath(".//*[@id='conteudo_lblNome']"));
                    writer.append(nm_empresa.getText() + ";");

                    WebElement rz_social = driver.findElement(By.xpath(".//*[@id='conteudo_lblRazao']"));
                    writer.append(rz_social.getText() + ";");

                    WebElement telefone = driver.findElement(By.xpath(".//*[@id='conteudo_lblTelefone']"));
                    writer.append(telefone.getText() + ";");

                    WebElement site_empresa = driver.findElement(By.xpath(".//*[@id='conteudo_linkSite']"));
                    writer.append(site_empresa.getText() + ";");

                    WebElement email_empresa = driver.findElement(By.xpath(".//*[@id='conteudo_linkEmail']"));
                    writer.append(email_empresa.getText() + ";");

                    WebElement end_empresa = driver.findElement(By.xpath(".//*[@id='conteudo_lblEndereco']"));
                    writer.append(end_empresa.getText() + ";");

                    WebElement cnae_empresa = driver.findElement(By.xpath(".//*[@id='conteudo_lblDivisaoCnae']"));
                    writer.append(cnae_empresa.getText() + ";");

                    WebElement prod_serv = driver.findElement(By.xpath(".//*[@id='conteudo_divProdutosServicos']"));
                    writer.append(prod_serv.getText() + ";");

                    WebElement porte_empresa = driver.findElement(By.xpath(".//*[@id='conteudo_lblPorte']"));
                    writer.append(porte_empresa.getText() + ";");

                    writer.append("\n");

                    //System.out.println(divDadosEmpresa.getText());
                    //writer.append(divDadosEmpresa.getText());

                    System.out.println("*FIM*");
                    }catch (org.openqa.selenium.NoSuchElementException e3) {
                    System.out.println("Alguns Elementos não foram encontrados" + e3.getMessage());
            }
        }
        br.close();
        writer.close();

        }catch (FileNotFoundException e1) {
             // TODO Auto-generated catch block
        }catch (IOException e2){
            // TODO Auto-generated catch block
        }
    }
}
