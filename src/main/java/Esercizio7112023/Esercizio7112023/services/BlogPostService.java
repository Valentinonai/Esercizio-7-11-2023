package Esercizio7112023.Esercizio7112023.services;

import Esercizio7112023.Esercizio7112023.entities.BlogPost;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    List<BlogPost> blogPosts=new ArrayList<>();
    File blogPostFile=new File("src/main/java/files/blogPost.txt");

    public List<BlogPost> getAllBlogPosts(){
        blogPosts.removeAll(blogPosts);
        try {
            String fileReader = FileUtils.readFileToString(blogPostFile, StandardCharsets.UTF_8);
            List<String> str = new ArrayList<>(List.of(fileReader.split("#")));
            for (int i = 0; i < str.size(); i++) {
                List<String> app = new ArrayList<>(List.of(str.get(i).split("@")));
                blogPosts.add(new BlogPost(Integer.parseInt(app.get(0)),app.get(1),app.get(2),app.get(3),app.get(4),Integer.parseInt(app.get(5))));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return blogPosts;
    }

    public BlogPost getSingleBlogPost(int id) {
        try {
            String fileReader = FileUtils.readFileToString(blogPostFile, StandardCharsets.UTF_8);
            List<String> str = new ArrayList<>(List.of(fileReader.split("#")));
            for (int i = 0; i < str.size(); i++) {
                List<String> app = new ArrayList<>(List.of(str.get(i).split("@")));
                blogPosts.add(new BlogPost(Integer.parseInt(app.get(0)),app.get(1),app.get(2),app.get(3),app.get(4),Integer.parseInt(app.get(5))));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            for(int i=0;i<blogPosts.size();i++){
                if(blogPosts.get(i).getId()==id)
                    return blogPosts.get(i);
            }
        throw new RuntimeException("Elemento non trovato");
    }

    public int saveNewPost(BlogPost p) throws IOException {
        Random rnd=new Random();
        p.setId(rnd.nextInt(1,10000));
        blogPosts.add(p);
        String obj=p.getId()+"@"+p.getCategoria()+"@"+p.getTitolo()+"@"+"https://picsum.photos/200/300"+"@"+p.getContenuto()+"@"+p.getTempoDiLettura()+"#";
        FileUtils.writeStringToFile(blogPostFile,obj, StandardCharsets.UTF_8,true);
        return p.getId();
    }

    public BlogPost modifyBlogPost(BlogPost p,int id) throws IOException {
        blogPosts.removeAll(blogPosts);
        try {
            String fileReader = FileUtils.readFileToString(blogPostFile, StandardCharsets.UTF_8);
            List<String> str = new ArrayList<>(List.of(fileReader.split("#")));
            for (int i = 0; i < str.size(); i++) {
                List<String> app = new ArrayList<>(List.of(str.get(i).split("@")));
                blogPosts.add(new BlogPost(Integer.parseInt(app.get(0)),app.get(1),app.get(2),app.get(3),app.get(4),Integer.parseInt(app.get(5))));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<blogPosts.size();i++){
            if(blogPosts.get(i).getId()==id){
                blogPosts.get(i).setContenuto(p.getContenuto());
                blogPosts.get(i).setCategoria(p.getCategoria());
                blogPosts.get(i).setTitolo(p.getTitolo());
                blogPosts.get(i).setCover("https://picsum.photos/200/300");
                blogPosts.get(i).setTempoDiLettura(p.getTempoDiLettura());
                FileUtils.writeStringToFile(blogPostFile,"", StandardCharsets.UTF_8);
                for(int j=0;j<blogPosts.size();j++){
                    String obj=blogPosts.get(j).getId()+"@"+blogPosts.get(j).getCategoria()+"@"+blogPosts.get(j).getTitolo()+"@"+blogPosts.get(j).getCover()+"@"+blogPosts.get(j).getContenuto()+"@"+blogPosts.get(j).getTempoDiLettura()+"#";
                    FileUtils.writeStringToFile(blogPostFile,obj, StandardCharsets.UTF_8,true);
                }
                return blogPosts.get(i);
            }

        }

        throw new RuntimeException("Elemento non trovato");
    }

    public void deleteSingleBlogPost(int id) throws IOException {
        blogPosts.removeAll(blogPosts);
        try {
            String fileReader = FileUtils.readFileToString(blogPostFile, StandardCharsets.UTF_8);
            List<String> str = new ArrayList<>(List.of(fileReader.split("#")));
            for (int i = 0; i < str.size(); i++) {
                List<String> app = new ArrayList<>(List.of(str.get(i).split("@")));
                blogPosts.add(new BlogPost(Integer.parseInt(app.get(0)),app.get(1),app.get(2),app.get(3),app.get(4),Integer.parseInt(app.get(5))));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Iterator<BlogPost> i=blogPosts.iterator();
        while(i.hasNext()){
            BlogPost current=i.next();
            if(current.getId()==id)
            {
                i.remove();
            }
        }
        FileUtils.writeStringToFile(blogPostFile,"", StandardCharsets.UTF_8);
        for(int j=0;j<blogPosts.size();j++){
            String obj=blogPosts.get(j).getId()+"@"+blogPosts.get(j).getCategoria()+"@"+blogPosts.get(j).getTitolo()+"@"+blogPosts.get(j).getCover()+"@"+blogPosts.get(j).getContenuto()+"@"+blogPosts.get(j).getTempoDiLettura()+"#";
            FileUtils.writeStringToFile(blogPostFile,obj, StandardCharsets.UTF_8,true);
        }

    }
}
