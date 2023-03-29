/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Ahmed salah
 */
public interface librarianInterface extends Remote{
 
    
    public void ModifyBookData(int BID,String WhatToChange,String newData)throws RemoteException;
    public void DeleteBookData( int BookID)throws RemoteException;
    public void setm()throws RemoteException;
    public void FileReport(int id,int AccountID,String Description)throws RemoteException;
    public void insertBook(int bid,String Title,String PY,String au,String wn,String d)throws RemoteException;
}
