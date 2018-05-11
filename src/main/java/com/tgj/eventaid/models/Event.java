package com.tgj.eventaid.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.soap.Text;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue
	private long id;

	@NotBlank(message = "Must have Event Name")
	@Size(min = 3, message = "An Event Name must be at least 3 characters.")
	@Column(nullable = false)
	private String name;

	@NotNull(message = "Must have Start Date")
	@Column(nullable = false)
	private Date start_date;

	@NotNull(message = "Must have End Date")
	@Column(nullable = false)
	private Date end_date;

	@NotBlank(message = "Must have Location for Event")
	@Column(nullable = false)
	private String location;

	@NotBlank(message = "Must have Description")
	@Column(nullable = false)
	private String description;

	@NotNull(message = "Must have Ticket Amount")
	@Column(nullable = false)
	private int tickets_available;

	@Column(nullable = false)
	private BigDecimal tickets_price;

	@Column()
	private String media_location;

	@Column()
	private String url;

	// included budget info in table

	@Column(nullable = false)
	private BigDecimal event_budget;

	@Column(nullable = false)
	private BigDecimal target_spending;

	@Column(nullable = false)
	private BigDecimal target_profit;

	// end of budget info

	@OneToOne  // relationship to events.id
	@JoinColumn(name = "venue_id")
	private Venue venue_id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private List<Artist> artists;

    // tickets added by Edwin
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event_id")
    private List<Ticket> tickets;

    public Event() {}

    public Event(long id, String name, Date start_date, Date end_date, String location, String url, Venue venue_id, String media_location, int tickets_available, String description, BigDecimal tickets_price, BigDecimal event_budget, BigDecimal target_profit, BigDecimal target_spending, List<Artist> artists, User user, List<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.url = url;
        this.venue_id = venue_id;
        this.media_location = media_location;
        this.tickets_available = tickets_available;
        this.description = description;
        this.tickets_price = tickets_price;
        this.event_budget = event_budget;
        this.target_profit = target_profit;
        this.target_spending = target_spending;
        this.artists = artists;
        this.user = user;
        this.tickets = tickets;
    }

    // insert new event
    public Event(String name, Date start_date, Date end_date, String location, String url, Venue venue_id, String media_location, int tickets_available, String description, BigDecimal tickets_price, BigDecimal event_budget, BigDecimal target_profit, BigDecimal target_spending, List<Artist> artists, List<Ticket> tickets) {
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.location = location;
        this.url = url;
        this.venue_id = venue_id;
        this.media_location = media_location;
        this.tickets_available = tickets_available;
        this.description = description;
        this.tickets_price = tickets_price;
        this.event_budget = event_budget;
        this.target_profit = target_profit;
        this.target_spending = target_spending;
        this.artists = artists;
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public BigDecimal getEvent_budget() {
        return event_budget;
    }

    public void setEvent_budget(BigDecimal event_budget) {
        this.event_budget = event_budget;
    }

    public BigDecimal getTarget_spending() {
        return target_spending;
    }

    public void setTarget_spending(BigDecimal target_spending) {
        this.target_spending = target_spending;
    }

    public BigDecimal getTarget_profit() {
        return target_profit;
    }

    public void setTarget_profit(BigDecimal target_profit) {
        this.target_profit = target_profit;
    }

    public BigDecimal getTickets_price() {
        return tickets_price;
    }

    public void setTickets_price(BigDecimal tickets_price) {
        this.tickets_price = tickets_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTickets_available() {
        return tickets_available;
    }

    public void setTickets_available(int tickets_available) {
        this.tickets_available = tickets_available;
    }

    public String getMedia_location() {
        return media_location;
    }

    public void setMedia_location(String media_location) {
        this.media_location = media_location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Venue getVenue_id() {
		return venue_id;
	}

	public void setVenue_id(Venue venue_id) {
		this.venue_id = venue_id;
	}

    public User getUser() {
        return user;
    }

	public void setUser(User user) {
		this.user = user;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getDateString() {
		DateFormat formatter = new SimpleDateFormat();
		return formatter.format(this.start_date);
	}
}
