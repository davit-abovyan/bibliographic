package am.bibliographic.api.v1;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

public class APIController {
    protected static Gson gson = new Gson();
    protected final Logger LOGGER = Logger.getLogger(APIController.class);
}

