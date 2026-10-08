// Abstract Class: Represents a core identity base class
abstract class CloudStorage {
    protected String bucketName;

    // Abstract classes CAN have constructors to initialize shared state
    public CloudStorage(String bucketName) {
        this.bucketName = bucketName;
    }

    // Concrete method: shared common logic
    public void logOperation(String action) {
        System.out.printf("[LOG] Bucket '%s': %s%n", bucketName, action);
    }

    // Abstract method: forces subclasses to provide specific implementation
    public abstract void uploadFile(String fileName);
}

class AwsS3Storage extends CloudStorage {
    public AwsS3Storage(String bucketName) {
        super(bucketName);
    }

    @Override
    public void uploadFile(String fileName) {
        logOperation("Uploading via AWS SDK v2 multipart transfer");
        System.out.printf("File '%s' successfully uploaded to S3 bucket '%s'.%n", fileName, bucketName);
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        // CloudStorage storage = new CloudStorage("bucket"); // COMPILE ERROR: Cannot instantiate abstract class
        CloudStorage s3 = new AwsS3Storage("production-assets");
        s3.uploadFile("backup.tar.gz");
    }
}