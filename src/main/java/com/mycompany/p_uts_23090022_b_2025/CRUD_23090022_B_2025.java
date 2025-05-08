/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p_uts_23090022_b_2025;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 *
 * @author ASUS
 */
public class CRUD_23090022_B_2025 {
  public static void main(String[] args) {
        String URL = "mongodb://localhost:27017";
        try (MongoClient mongo = MongoClients.create(URL)) {
            MongoDatabase DB = mongo.getDatabase("uts_230900022_B_2025");
            MongoCollection<Document> collection = DB.getCollection("coll_23090022_B_2025");
            //Insert
            Document product = new Document("name", "Printer")
                    .append("Kategori ","Elektronik")
                    .append("Harga", 1500000);
            Document product1 = new Document("name", "Laptop")
                    .append("Kategori ","Elektronik")
                    .append("Harga", 8000000);
                    
            collection.insertOne(product);
            
            //Views Data
            FindIterable<Document> products = collection.find();
            for (Document p : products) {
                System.out.println(p.toJson());
            }
            //Seacrh
            Document foundProduct = collection.find(Filters.eq("name", "Kulkas")).first();
            
            if (foundProduct != null) {
                System.out.println("Produk ditemukan:");
                System.out.println(foundProduct.toJson());
            } else{
                System.out.println("Produk tidak ditemukan.");
            }
            // Update harga printer jadi 1750000
            collection.updateOne(Filters.eq("nama", "Printer"), new Document("$set", new Document("harga", 1750000)));
            System.out.println("=== Data Printer berhasil diperbarui ===");
             // Hapus data Leptop
            collection.deleteOne(Filters.eq("nama", "Leptop"));
            System.out.println("=== Data Leptop berhasil dihapus ===");
        }catch (Exception e){
            
        }
    }


}


