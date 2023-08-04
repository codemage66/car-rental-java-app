package IO;

import Main.VehicleCompany;

import java.io.*;

public class MyFile implements Expositor {

    public void rentedSaver(VehicleCompany vehicleCompany){
        try{
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("rentedSaver.txt")));
            printWriter.println(vehicleCompany.toString());
            printWriter.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public String rentedReader(){
        String company = null;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("rentedSaver.txt"));
            company = bufferedReader.readLine();
            bufferedReader.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return company;
    }


    @Override
    public void fileExpositor(String line) {

    }
}
