


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author risin
 */
public class baglanti {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultset;
        PreparedStatement preparedStatement=null;
        
    
    public static Connection yap() throws SQLException{
       return DriverManager.getConnection("jdbc:derby://localhost:1527/Stadyum2", "emir", "123"); 
    }
    public static void showErrorMessage(SQLException exception){
        System.out.println("Error : "+exception.getMessage());
        System.out.println("Error Code: "+exception.getErrorCode());
    }
    public ArrayList<Musteri> getMusteri() throws SQLException{
         ArrayList<Musteri> musteriler=new ArrayList<Musteri>();
        try{
            connection=baglanti.yap();
            statement=connection.createStatement();
            resultset=statement.executeQuery("select AD,SOYAD,NUMARA,TC,BILET,BLOK,KOLTUK from MUSTERI ");
            while(resultset.next()){
                musteriler.add(new Musteri(
                resultset.getString("AD"),
                resultset.getString("SOYAD"),
                resultset.getString("NUMARA"),
                resultset.getString("TC"),
                resultset.getString("BILET"),
                resultset.getString("BLOK"),
                resultset.getInt("KOLTUK")));
            }
        }
        catch(SQLException exception){
            baglanti.showErrorMessage(exception);
        }
        finally{
            connection.close();
        }
        return musteriler;
    }
    public boolean addMusteri(String ad,String soyad,String no,String tc,String blok,String bilet,int koltuk)throws SQLException{
        String query="INSERT INTO MUSTERI"+"(AD,SOYAD,NUMARA,TC,BLOK,BILET,KOLTUK) VALUES" + "(?,?,?,?,?,?,?)";
        String query2="UPDATE KOLTUKLAR SET DURUM = 'DOLU' WHERE ODANO = " + koltuk + " AND BLOK =" + "'"+blok.charAt(0)+"'";
        String query3="SELECT * FROM MUSTERI WHERE KOLTUK="+koltuk+ " AND BLOK=" + "'"+blok.charAt(0)+"'";
        boolean key = false;
        int count=0;
        try{
            connection=baglanti.yap();
            statement=connection.createStatement();
            resultset=statement.executeQuery(query3);
            while(resultset.next()){
                count++;
            }
            if(count==0){
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, no);
            preparedStatement.setString(4, tc);
            preparedStatement.setString(5, blok);
            preparedStatement.setString(6, bilet);
            preparedStatement.setInt(7, koltuk);
            preparedStatement.executeUpdate();
            preparedStatement=connection.prepareStatement(query2);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null," İŞLEM BAŞARILI ! ");
            }
            else{
               JOptionPane.showMessageDialog(null," BU KOLTUK DOLUDUR ! "+" KOLTUK NO: "+koltuk+" BLOK "+ blok +"");  
            }
            key = true;
        }
        catch(SQLException e){
           showErrorMessage(e);
            //JOptionPane.showMessageDialog(null," HATA ! "+e.getMessage().toString());
        }
        connection.close();
        if(key){
            return true;
        }
        else{
            return false;
        }
              
    }
    public ArrayList<Durumlar> getDurum() throws SQLException{
         ArrayList<Durumlar> durumlar=new ArrayList<Durumlar>();
        try{
            connection=baglanti.yap();
            statement=connection.createStatement();
            resultset=statement.executeQuery("SELECT * FROM KOLTUKLAR WHERE BLOK= 'A'");
            while(resultset.next()){
                durumlar.add(new Durumlar(
                resultset.getInt("ODANO"),
                resultset.getString("BLOK"),
                resultset.getString("DURUM")
                ));
            }
        }
        catch(SQLException exception){
            baglanti.showErrorMessage(exception);
        }
        finally{
            connection.close();
        }
        return durumlar;
    }
     public ArrayList<Durumlar2> getDurumB() throws SQLException{
         ArrayList<Durumlar2> durumlar=new ArrayList<Durumlar2>();
        try{
            connection=baglanti.yap();
            statement=connection.createStatement();
            resultset=statement.executeQuery("SELECT * FROM KOLTUKLAR WHERE BLOK= 'B'");
            while(resultset.next()){
                durumlar.add(new Durumlar2(
                resultset.getInt("ODANO"),
                resultset.getString("BLOK"),
                resultset.getString("DURUM")
                ));
            }
        }
        catch(SQLException exception){
            baglanti.showErrorMessage(exception);
        }
        finally{
            connection.close();
        }
        return durumlar;
    }
     public ArrayList<Durumlar3> getDurumC() throws SQLException{
         ArrayList<Durumlar3> durumlar=new ArrayList<Durumlar3>();
        try{
            connection=baglanti.yap();
            statement=connection.createStatement();
            resultset=statement.executeQuery("SELECT * FROM KOLTUKLAR WHERE BLOK= 'C'");
            while(resultset.next()){
                durumlar.add(new Durumlar3(
                resultset.getInt("ODANO"),
                resultset.getString("BLOK"),
                resultset.getString("DURUM")
                ));
            }
        }
        catch(SQLException exception){
            baglanti.showErrorMessage(exception);
        }
        finally{
            connection.close();
        }
        return durumlar;
    }
     public ArrayList<Durumlar4> getDurumD() throws SQLException{
         ArrayList<Durumlar4> durumlar=new ArrayList<Durumlar4>();
        try{
            connection=baglanti.yap();
            statement=connection.createStatement();
            resultset=statement.executeQuery("SELECT * FROM KOLTUKLAR WHERE BLOK= 'D'");
            while(resultset.next()){
                durumlar.add(new Durumlar4(
                resultset.getInt("ODANO"),
                resultset.getString("BLOK"),
                resultset.getString("DURUM")
                ));
            }
        }
        catch(SQLException exception){
            baglanti.showErrorMessage(exception);
        }
        finally{
            connection.close();
        }
        return durumlar;
    }
     public boolean removeMusteri(String tc)throws SQLException{
        String query1="SELECT * FROM MUSTERI WHERE TC=" + "'" +tc+ "'";
        
        boolean deger=false;
        boolean key = false;
        ArrayList<Musteri> musteriler=new ArrayList<Musteri>();
         musteriler=getMusteri();
         for(int i=0;i<musteriler.size();i++){
                if(String.valueOf(musteriler.get(i).getMusteriTcKimlik()).equals(String.valueOf(tc))){
                    deger=true;
                }
            }
        if(deger){
        String query="DELETE FROM MUSTERI WHERE TC=?";
        try{
            connection=baglanti.yap();
            statement=connection.createStatement();
            preparedStatement=connection.prepareStatement(query);
            resultset=statement.executeQuery(query1);
            preparedStatement.setString(1, tc);            
            preparedStatement.executeUpdate();
             while(resultset.next()){
          preparedStatement=connection.prepareStatement("UPDATE KOLTUKLAR SET DURUM = 'BOS' WHERE ODANO = " + resultset.getInt("KOLTUK") + " AND BLOK =" + "'"+resultset.getString("BLOK")+"'");
        }
          preparedStatement.executeUpdate();
            key = true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null," HATA ! "+e.getMessage().toString());
        }
        }
        connection.close();
        if(key && deger){
            return true;
        }
        else{
            return false;
        }
              
    }
}
