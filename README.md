# Retrofit Dynamic Endpoint Sample
I just wanted to quickly test if Retrofit handles a mutable endpoint which url can be modified. Since it works fine, I'll just share it here too.

### The magic 
```java
public class MutableEndpoint implements Endpoint {

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getName() {
        return url;
    }
}
```
