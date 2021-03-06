/**
 * 
 */
package mx.tec.web.project.security;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import mx.tec.web.project.manager.LoginManager;
import mx.tec.web.project.util.JsonWebTokenUtil;

/**
 * @author Usuario
 *
 */
@Component
public class JsonWebTokenRequestFilter extends OncePerRequestFilter {
	
	/**
	 * A reference to Login Manager
	 */
	@Autowired
	private LoginManager loginManager;
	
	/**
	 * A reference to JsonWebTokenUtil
	 */
	@Autowired
	private JsonWebTokenUtil tokenUtil;
	
	/**
	 * Method to create the filter, checking if the request has the authorization token nedeed to proceed
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String token = null;

		if (null != requestTokenHeader && requestTokenHeader.startsWith("Bearer ")) {
			token = requestTokenHeader.substring(7);

			try {
				username = tokenUtil.getUsernameFromToken(token);
			} catch (IllegalArgumentException iae) {
				logger.error("Unable to get JWT Token", iae);
			} catch (ExpiredJwtException eje) {
				logger.error("JWT Token has expired", eje);
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		if (null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
			Optional<UsernamePasswordAuthenticationToken> authenticationToken = loginManager.authenticate(username, token);
			if (authenticationToken.isPresent()) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = authenticationToken.get();
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		chain.doFilter(request, response);
	}
}
