package com.tech.blog.dao;

import com.tech.blog.entities.Categories;
import com.tech.blog.entities.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    Connection con;
    public PostDao(Connection con){
        this.con=con;
    }
    
    public ArrayList<Categories> getAllCategories(){
       ArrayList<Categories> list=new ArrayList<>();
       
       try{
         String q="select * from categories";
         Statement st= this.con.createStatement();
         ResultSet set=st.executeQuery(q);
         while(set.next()){
           int cId=set.getInt("cId");
           String name=set.getString("name");
           String description=set.getString("description");
           
           Categories c = new Categories(cId,name,description);
           list.add( c );
           
         }
       
       }catch(Exception e){
           e.printStackTrace();
       }
       
        return list;
    }
    
    public boolean savePost(Post p){
       boolean flag = false;
       try{
           String query="insert into posts (pTitle,pContent,pCode,pPic,c_Id,u_Id) values(?,?,?,?,?,?)";
           PreparedStatement pstmt=con.prepareStatement(query);
           pstmt.setString(1,p.getpTitle());
           pstmt.setString(2,p.getpContent());
           pstmt.setString(3,p.getpCode());
           pstmt.setString(4,p.getpPic());
           pstmt.setInt(5,p.getC_Id());
           pstmt.setInt(6,p.getU_Id());
           pstmt.executeUpdate();
           flag=true;
           
       }catch(Exception e){
         e.printStackTrace();  
       }
       return flag;
    }
    
    public List<Post> getAllPosts(){
        List<Post> list= new ArrayList<Post>();
        //fetch all posts
        
        try{
            PreparedStatement p=con.prepareCall("select * from posts order by pid desc");
            
            ResultSet set=p.executeQuery();
            
            while(set.next()){
                
                
                int pId = set.getInt("pId");
                String pTitle= set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp pDate=set.getTimestamp("pDate");
                int c_Id=set.getInt("c_Id");
                int u_Id=set.getInt("u_Id");
                
                Post post = new Post(pId, pTitle, pContent, pCode, pPic, pDate, c_Id, u_Id);
                
                list.add(post);
              
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return list;
    }
    
    public List<Post> getPostByCatId(int catId){
     List<Post> list= new ArrayList<Post>();
        //fetch categorywise posts
        
        try{
            PreparedStatement p=con.prepareCall("select * from posts where c_Id=?");
            p.setInt(1, catId);
            ResultSet set=p.executeQuery();
            
            
            while(set.next()){
                
                int pId = set.getInt("pId");
                String pTitle= set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp pDate=set.getTimestamp("pDate");
                int c_Id=set.getInt("c_Id");
                int u_Id=set.getInt("u_Id");
                
                Post post = new Post(pId, pTitle, pContent, pCode, pPic, pDate, c_Id, u_Id);
                
                list.add(post);
              
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
      
        return list;
    }
    
    public Post getPostByPostId(int postId){
        Post post=null;
        String q= "select * from posts where pId=?";
        try{
        PreparedStatement p = this.con.prepareStatement(q);
        p.setInt(1,postId);
        ResultSet set=p.executeQuery();
        if(set.next()){
            
            int pId = set.getInt("pId");
                String pTitle= set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode=set.getString("pCode");
                String pPic=set.getString("pPic");
                Timestamp pDate=set.getTimestamp("pDate");
                int c_Id=set.getInt("c_Id");
                int u_Id=set.getInt("u_Id");
                
                post = new Post(pId, pTitle, pContent, pCode, pPic, pDate, c_Id, u_Id);
        
          
        }
        }catch(Exception e){
        e.printStackTrace();
        }
        
     return post;
    }
    
}
