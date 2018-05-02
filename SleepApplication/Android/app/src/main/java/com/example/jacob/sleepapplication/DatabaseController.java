package com.example.jacob.sleepapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class DatabaseController extends AsyncTask<String, Void, String> {

    public String result;
    public AsyncResponse delegate = null;
    Context context;
    private AlertDialog alertDialog;
    private String type;

    DatabaseController(Context ctx, AsyncResponse delegate) {
        context = ctx;
        this.delegate = delegate;
    }

    DatabaseController(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        this.type = params[0];
        String login_url = "http://212.10.146.182:8080/login.php";
        String register_url = "http://212.10.146.182:8080/register.php";
        String timer_url = "http://212.10.146.182:8080/timer.php";
        String consent_url = "http://212.10.146.182:8080/consent.php";
        String assessment_url = "http://212.10.146.182:8080/assessment.php";
        System.out.println(type);
        if (type.equals("login")) {
            try {
                String student_id = params[1];
                String student_pass = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("student_id", "UTF-8") + "=" + URLEncoder.encode(student_id, "UTF-8") + "&"
                        + URLEncoder.encode("student_pass", "UTF-8") + "=" + URLEncoder.encode(student_pass, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                StudentModel.student_id = student_id;
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (type.equals("register")) {
            try {
                String student_pass = params[1];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("student_pass", "UTF-8") + "=" + URLEncoder.encode(student_pass, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (type.equals("timer")) {
            try {
                String sleep_time = params[1];
                String awoke_time = params[2];
                URL url = new URL(timer_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("student_id", "UTF-8") + "=" + URLEncoder.encode(StudentModel.student_id, "UTF-8") + "&" +
                                URLEncoder.encode("sleep_time", "UTF-8") + "=" + URLEncoder.encode(sleep_time, "UTF-8") + "&" +
                                URLEncoder.encode("awoke_time", "UTF-8") + "=" + URLEncoder.encode(awoke_time, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (type.equals("consent")) {
            try {
                String student_consent = params[1];
                URL url = new URL(consent_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("student_id", "UTF-8") + "=" + URLEncoder.encode(StudentModel.student_id, "UTF-8") + "&" +
                                URLEncoder.encode("student_consent", "UTF-8") + "=" + URLEncoder.encode(student_consent, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (type.equals("assessment")) {
            try {
                String student_id = params[1];
                URL url = new URL(assessment_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("student_id", "UTF-8") + "=" + URLEncoder.encode(student_id, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String result) {
        if (type.equalsIgnoreCase("login") ||
                type.equalsIgnoreCase("register") ||
                type.equalsIgnoreCase("consent") ||
                type.equalsIgnoreCase("timer")) {
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setTitle("Login Status");
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        if (delegate != null) {
            delegate.processFinish(result);
        }
        String registerSubString = "Insert successful: Student_id = ";

        if (result.equalsIgnoreCase("login success")) {
            Intent Intent = new Intent(context, MainActivity.class);
            context.startActivity(Intent);
        }
        if (result.startsWith("Insert successful: Student_id")) {
            alertDialog.setMessage("Brugernavn: " + result.replace(registerSubString, ""));
            Intent Intent = new Intent(context, LoginActivity.class);
            context.startActivity(Intent);
        }
        if (result.startsWith("Data: ")) {

        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    public interface AsyncResponse {
        void processFinish(String output);
    }


}