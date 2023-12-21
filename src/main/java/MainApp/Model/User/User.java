package MainApp.Model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import MainApp.Constants.Constants;

@Entity
@Table(name = Constants.Tables.USERS)
public class User
{
	public User()
	{
		this.accessLevel = AccessLevel.VISITOR;
	}
	
	public User(final String username, final String password)
	{
		this.username = username;
		this.password = password;
		this.accessLevel = AccessLevel.VISITOR;
	}
	
	public boolean isOperator()
	{
		return accessLevel == AccessLevel.OPERATOR;
	}
	
	public boolean hasPassword(final String password)
	{
		return this.password.equals(password);
	}
	
	public Long getId()
	{
        return this.id;
    }
	
	public void setId(final Long id)
	{
        this.id = id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(final String username)
	{
    	this.username = username;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(final String password)
	{
    	this.password = password;
    }

    public AccessLevel getAccessLevel()
    {
        return this.accessLevel;
    }
    
    public void setAccessLevel(final AccessLevel accessLevel)
	{
    	this.accessLevel = accessLevel;
    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Constants.UserFields.ID)
	private Long id;
	@Column(name = Constants.UserFields.USERNAME, length = Constants.UserFields.USERNAME_LENGTH, nullable = Constants.Nullable.NO)
	private String username;
	@Column(name = Constants.UserFields.PASSWORD, length = Constants.UserFields.PASSWORD_LENGTH, nullable = Constants.Nullable.NO)
    private String password;
	@Column(name = Constants.UserFields.ACCESS_LEVEL, nullable = Constants.Nullable.NO)
	@Enumerated(EnumType.ORDINAL)
    private AccessLevel accessLevel;
} //nu merge la numele field-urilor sa pui _ la final ca nu le mai recunoaste spring boot :(