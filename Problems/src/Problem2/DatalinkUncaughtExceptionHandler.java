package Problem2;

public class DatalinkUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{
    private Throwable thrown = null;

    @Override
    public void uncaughtException(Thread thread, Throwable exception)
    {
        System.out.println("Caught exception from a background thread:" + exception.getLocalizedMessage());
        this.thrown = exception;
    }

    public Throwable getThrown()
    {
        return thrown;
    }
}
