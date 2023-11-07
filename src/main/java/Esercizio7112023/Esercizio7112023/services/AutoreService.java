package Esercizio7112023.Esercizio7112023.services;

import Esercizio7112023.Esercizio7112023.entities.Autore;
import Esercizio7112023.Esercizio7112023.entities.BlogPost;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    List<Autore> autoreList = new ArrayList<>();
    File authorFile = new File("src/main/java/files/author.txt");

    public List<Autore> getAllAuthors() {
        autoreList.removeAll(autoreList);
        try {
            String fileReader = FileUtils.readFileToString(authorFile, StandardCharsets.UTF_8);
            List<String> str = new ArrayList<>(List.of(fileReader.split("#")));
            for (int i = 0; i < str.size(); i++) {
                List<String> app = new ArrayList<>(List.of(str.get(i).split("£")));
                autoreList.add(new Autore(Integer.parseInt(app.get(0)), app.get(1), app.get(2), app.get(3),LocalDate.parse(app.get(4)) , app.get(5)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return autoreList;
    }

    public Autore getSingleAuthor(int id) {
        try {
            String fileReader = FileUtils.readFileToString(authorFile, StandardCharsets.UTF_8);
            List<String> str = new ArrayList<>(List.of(fileReader.split("#")));
            for (int i = 0; i < str.size(); i++) {
                List<String> app = new ArrayList<>(List.of(str.get(i).split("£")));
                autoreList.add(new Autore(Integer.parseInt(app.get(0)), app.get(1), app.get(2), app.get(3),LocalDate.parse(app.get(4)), app.get(5)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        for (int i = 0; i < autoreList.size(); i++) {
            if (autoreList.get(i).getId() == id) {
                return autoreList.get(i);
            }
        }
        throw new RuntimeException("Elemento non trovato");
    }


    public int saveNewAuthor(Autore a) throws IOException {
        Random rnd=new Random();
        a.setId(rnd.nextInt(1,10000));
        a.setAvatar(a.getNome()+" "+a.getCognome());
        autoreList.add(a);
            String obj=a.getId()+"£"+a.getNome()+"£"+a.getCognome()+"£"+a.getEmail()+"£"+a.getDataDiNascita().toString()+"£"+a.getAvatar()+"#";
            FileUtils.writeStringToFile(authorFile,obj, StandardCharsets.UTF_8,true);
        return a.getId();
    }

    public Autore modifyAuthor(Autore a,int id) throws IOException {
        autoreList.removeAll(autoreList);
        try {
            String fileReader = FileUtils.readFileToString(authorFile, StandardCharsets.UTF_8);
            List<String> str = new ArrayList<>(List.of(fileReader.split("#")));
            for (int i = 0; i < str.size(); i++) {
                List<String> app = new ArrayList<>(List.of(str.get(i).split("£")));
                autoreList.add(new Autore(Integer.parseInt(app.get(0)),app.get(1),app.get(2),app.get(3),LocalDate.parse(app.get(4)),app.get(5)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<autoreList.size();i++){
            if(autoreList.get(i).getId()==id){
                 autoreList.get(i).setNome(a.getNome());
                 autoreList.get(i).setCognome(a.getCognome());
                 autoreList.get(i).setEmail(a.getEmail());
                 autoreList.get(i).setDataDiNascita(a.getDataDiNascita());
                 autoreList.get(i).setNome(a.getNome()+" "+a.getCognome());
                FileUtils.writeStringToFile(authorFile,"", StandardCharsets.UTF_8);
                for(int j=0;j<autoreList.size();j++){
                    String obj=autoreList.get(j).getId()+"£"+autoreList.get(j).getNome()+"£"+autoreList.get(j).getCognome()+"£"+autoreList.get(j).getEmail()+"£"+autoreList.get(j).getDataDiNascita().toString()+"£"+autoreList.get(j).getAvatar()+"#";
                    FileUtils.writeStringToFile(authorFile,obj, StandardCharsets.UTF_8,true);
                }
                return autoreList.get(i);
            }
        }
        throw new RuntimeException("Elemento non trovato");
    }

    public void deleteSingleAuthor(int id) throws IOException {
        autoreList.removeAll(autoreList);
        try {
            String fileReader = FileUtils.readFileToString(authorFile, StandardCharsets.UTF_8);
            List<String> str = new ArrayList<>(List.of(fileReader.split("#")));
            for (int i = 0; i < str.size(); i++) {
                List<String> app = new ArrayList<>(List.of(str.get(i).split("£")));
                autoreList.add(new Autore(Integer.parseInt(app.get(0)),app.get(1),app.get(2),app.get(3),LocalDate.parse(app.get(4)),app.get(5)));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator<Autore> i=autoreList.iterator();
        while (i.hasNext()){
            Autore current=i.next();
            if(current.getId()==id){
                i.remove();
            }
        }
        FileUtils.writeStringToFile(authorFile,"", StandardCharsets.UTF_8);
        for(int j=0;j<autoreList.size();j++){
            String obj=autoreList.get(j).getId()+"£"+autoreList.get(j).getNome()+"£"+autoreList.get(j).getCognome()+"£"+autoreList.get(j).getEmail()+"£"+autoreList.get(j).getDataDiNascita().toString()+"£"+autoreList.get(j).getAvatar()+"#";
            FileUtils.writeStringToFile(authorFile,obj, StandardCharsets.UTF_8,true);
        }
    }
}
