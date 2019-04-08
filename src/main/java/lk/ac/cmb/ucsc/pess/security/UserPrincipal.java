package lk.ac.cmb.ucsc.pess.security;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lk.ac.cmb.ucsc.pess.model.UserCredential;

@SuppressWarnings("serial")
public class UserPrincipal implements UserDetails {

	private long id;

	private String username;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	private boolean enabled;

	public UserPrincipal(long id, String username, String password, boolean enabled,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrincipal create(UserCredential userCredential) {
		List<GrantedAuthority> authorities = new LinkedList<>();
		authorities.add(new SimpleGrantedAuthority(userCredential.getUserRole().name()));

		return new UserPrincipal(userCredential.getId(), userCredential.getUsername(), userCredential.getPassword(),
				userCredential.isEnabled(), authorities);
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !enabled;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
