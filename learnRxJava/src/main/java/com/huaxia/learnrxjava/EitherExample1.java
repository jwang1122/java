package com.huaxia.learnrxjava;

import fj.data.Either;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.URL;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class EitherExample1{

  public static void main(String[] args){
    final String url = "http://localhost:5000/books";
    String filename = "books.json";
    final Either<Exception,String> str = get(filename);
    if(str.isRight()){
      final Either<Exception,JsonNode> json = parse(str.right().value());
      if(json.isRight()){
        System.out.println(json.right().value());
      }else{
        System.out.println(json.left().value());
      }
    }else{
       System.out.println(str.left().value());
    }
    System.out.println("Done.");
  }

  static final Either<Exception,JsonNode> parse(final String jsonString){
    try{
      return Either.right(new ObjectMapper().readValue(jsonString,JsonNode.class));
    }catch(Exception e){
      return Either.left(e);
    }
  }

  static final Either<Exception,String> get(final String urlString){
    try{
      final URL url = new URL(urlString);
      InputStream content = (InputStream)url.getContent();
      final BufferedReader bf = new BufferedReader(new InputStreamReader(content));
      String line;
      final StringBuilder sb = new StringBuilder();
      while ((line = bf.readLine()) != null){
        sb.append(line + "\n");
      }
      return Either.right(sb.toString());
    }catch(Exception e){
      return Either.left(e);
    }
  }
}