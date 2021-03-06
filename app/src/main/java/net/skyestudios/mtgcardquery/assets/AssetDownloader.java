package net.skyestudios.mtgcardquery.assets;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by arkeonet64 on 3/6/2017.
 */
public class AssetDownloader extends AsyncTask<Void, Void, Void> {
    private String html;
    private BitmapDrawable drawable;
    private Activity activity;

    /**
     * Creates a new asynchronous task. This constructor must be invoked on the UI thread.
     */
    public AssetDownloader(String html, Activity activity) {
        super();
        this.html = html;
        this.activity = activity;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Void doInBackground(Void... params) {
        try {
            String url = "http://magiccards.info/query?q=" + "Akroma's+Memorial";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Parse Document page (response)
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.</p>
     * <p>
     * <p>This method won't be invoked if the task was cancelled.</p>
     *
     * @param aVoid The result of the operation computed by {@link #doInBackground}.
     * @see #onPreExecute
     * @see #doInBackground
     * @see #onCancelled(Object)
     */
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        /*((ImageView) activity.findViewById(R.id.cardImage_ImageView)).setImageDrawable(drawable);

        final File DCIM_Directory = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),
                activity.getString(R.string.app_name));
        if (!DCIM_Directory.exists()) {
            DCIM_Directory.mkdirs();
        }

        //Save image to MTG Card Query's DCIM directory
        activity.findViewById(R.id.cardImage_ImageView).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    File savedImage = new File(DCIM_Directory, "Akroma's Memorial.png");
                    savedImage.createNewFile();
                    FileOutputStream FOS = new FileOutputStream(savedImage);
                    Bitmap bitmap = drawable.getBitmap();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, FOS);
                    FOS.flush();
                    FOS.close();
                    Toast.makeText(activity, "Image: {" + savedImage.getName() + "} saved", Toast.LENGTH_LONG).show();

                    ContentValues values = new ContentValues();
                    values.put(MediaStore.Images.Media.TITLE, savedImage.getName());
                    values.put(MediaStore.Images.Media.DESCRIPTION, "A MTG Card");
                    values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
                    values.put(MediaStore.Images.ImageColumns.BUCKET_ID, savedImage.getName().toLowerCase().hashCode());
                    values.put(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME, savedImage.getName().toLowerCase());
                    values.put(MediaStore.Images.ImageColumns.TITLE, savedImage.getName());
                    values.put("_data", savedImage.getAbsolutePath());

                    ContentResolver contentResolver = activity.getContentResolver();
                    contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        });*/
    }
}
