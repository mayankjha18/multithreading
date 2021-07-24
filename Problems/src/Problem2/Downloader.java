package Problem2;

public class Downloader implements Runnable {

    @Override
    public void run() {
        //logic to  download
        System.out.println("Inside run method of Downloader");
        download();
    }

    private void download()
    {
         throw new RuntimeException("Download Failed");
    }
}
