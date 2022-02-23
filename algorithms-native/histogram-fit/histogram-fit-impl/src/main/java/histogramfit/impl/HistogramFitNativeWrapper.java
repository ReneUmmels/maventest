package histogramfit.impl;

public class HistogramFitNativeWrapper {
    public static native String histogramFit();

    static {
        final String extension = getExtension();
    }

    private static String getExtension() {
        String osName = System.getProperty("os.name");
        if (osName != null && osName.toLowerCase().contains("windows")) {
            return ".dll";
        }
        if (osName != null && osName.toLowerCase().contains("linux")) {
            return ".so";
        }
        throw new IllegalStateException(String.format("Unsupported operating system %s.", osName));
    }

}
