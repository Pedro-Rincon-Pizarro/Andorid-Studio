package com.example.appusuarios.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.appusuarios.ConsultarActivity;
import com.example.appusuarios.conexion.ConexionSQLite;
import com.example.appusuarios.modelo.Usuario;
import com.example.appusuarios.utilidades.Utilidades;

import java.util.ArrayList;

public class UsuarioDao
{
    SQLiteDatabase db;
    public SQLiteDatabase obtenerConexion(Context context)
    {

        try  {
            ConexionSQLite conexion = new ConexionSQLite(context, "bdUsuarios", null, 1);
            db = conexion.getWritableDatabase();
        }
        catch (Exception e)
        {

        }
        return db;
    }

    public long insertarUsuario(Context context, Usuario user)
    {
        ContentValues values;
        obtenerConexion(context.getApplicationContext());
        long rdoinsertar = 0;

        values = new ContentValues();
        values.put(Utilidades.CAMPO_DNI, user.getDNI());
        values.put(Utilidades.CAMPO_NOMBRE, user.getNombre());
        values.put(Utilidades.CAMPO_TELEFONO, user.getTelefono());

        try
        {
            rdoinsertar = db.insert(
                    Utilidades.TABLA_USUARIOS,
                    null,
                    values);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
        return rdoinsertar;
    }

    public int actualizarUsuario(Context context, Usuario user)
    {

        int filasAfectadas = 0;

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE, user.getNombre());
        values.put(Utilidades.CAMPO_TELEFONO, user.getTelefono());

        // Usamos el DNI como identificador único para la actualización
        String whereClause = Utilidades.CAMPO_DNI + " = ?";
        String[] whereArgs = {user.getDNI()};

        try
        {
            obtenerConexion(context.getApplicationContext());
            filasAfectadas = db.update(
                    Utilidades.TABLA_USUARIOS, // Nombre de la tabla
                    values,                    // Valores a actualizar
                    whereClause,               // Cláusula WHERE
                    whereArgs                  // Argumentos para WHERE
            );
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {
            db.close();
        }

        return filasAfectadas;
    }

    public Usuario consultarUsuario(Context context, String dni)
    {
        String [] parametros = {dni};
        String [] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_TELEFONO};
        Usuario user = new Usuario();


        try {
            obtenerConexion(context);
            Cursor cursor = db.query(Utilidades.TABLA_USUARIOS, campos, Utilidades.CAMPO_DNI + "=?", parametros, null, null, null);
            cursor.moveToFirst();
            user.setNombre(cursor.getString(0));
            user.setTelefono(cursor.getString(1));
            cursor.close();
        }
        catch (Exception e)
        {
            Toast.makeText(context, "El usuario no existe", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        db.close();
        return user;
    }

    public int eliminarUsuario(Context context,String dni)
    {
        int filasModificadas = 0;
        String whereClause = Utilidades.CAMPO_DNI + " = ?";
        String[] whereArgs = {dni};

        try {
            obtenerConexion(context.getApplicationContext());
            filasModificadas = db.delete(
                    Utilidades.TABLA_USUARIOS,
                    whereClause,
                    whereArgs);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  filasModificadas;
    }

    public void consultarTodosUsuarios(Context context, ArrayList<String> spinner, ArrayList<Usuario> usuarios)
    {
        usuarios = null;
        spinner = null;

        try
        {
            obtenerConexion(context.getApplicationContext());
            Usuario datosUsuario = null;

            Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIOS, null);
            if(cursor != null)
            {
                cursor.moveToFirst();
                do {
                    datosUsuario = new Usuario();
                    datosUsuario.setDNI(cursor.getString(0));
                    datosUsuario.setNombre(cursor.getString(1));
                    datosUsuario.setTelefono(cursor.getString(2));
                    usuarios.add(datosUsuario);
                }while (cursor.moveToFirst());
                cargarSpinner(spinner, usuarios);
            }
        }
        catch(Exception e)
        {

        }


    }

    public void cargarSpinner(ArrayList<String> spinner, ArrayList<Usuario> usuarios)
    {
        spinner.add("Selecciona un usuario: ");

        for(int i = 0; i < spinner.size(); i++)
        {
            spinner.add((usuarios.get(1).getDNI() + usuarios.get(i).getNombre()));
        }
    }


}