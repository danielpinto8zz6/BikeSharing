package estg.mtsd.bikeshare.shared.library.utils;

import java.text.ParseException;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;

public class JwtUtils {
    public static String parseUserEmail(String token) {
        token = token.replace("Bearer ", "");

        try {
            JWT jwt = JWTParser.parse(token);

            JWTClaimsSet jwtClaimSet = jwt.getJWTClaimsSet();

            return jwtClaimSet.getSubject();

        } catch (ParseException e) {
            e.printStackTrace();

            return null;
        }
    }
}
