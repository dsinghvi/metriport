/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.medical.fhir.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = Filter.Builder.class
)
public final class Filter {
  private final String resources;

  private final Optional<String> dateFrom;

  private final Optional<String> dateTo;

  private final Map<String, Object> additionalProperties;

  private Filter(String resources, Optional<String> dateFrom, Optional<String> dateTo,
      Map<String, Object> additionalProperties) {
    this.resources = resources;
    this.dateFrom = dateFrom;
    this.dateTo = dateTo;
    this.additionalProperties = additionalProperties;
  }

  /**
   * @return Comma-separated list of resource types. If not specified on the
   * request, this will be <code>all</code>.
   */
  @JsonProperty("resources")
  public String getResources() {
    return resources;
  }

  /**
   * @return The start date (inclusive) for which to filter returned resources -
   * formatted <code>YYYY-MM-DD</code> as per ISO 8601. If not provided,
   * no start date filter will be applied.
   */
  @JsonProperty("dateFrom")
  public Optional<String> getDateFrom() {
    return dateFrom;
  }

  /**
   * @return The end date (inclusive) for which to filter returned resources -
   * formatted <code>YYYY-MM-DD</code> as per ISO 8601. If not provided,
   * no end date filter will be applied.
   */
  @JsonProperty("dateTo")
  public Optional<String> getDateTo() {
    return dateTo;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Filter && equalTo((Filter) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(Filter other) {
    return resources.equals(other.resources) && dateFrom.equals(other.dateFrom) && dateTo.equals(other.dateTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.resources, this.dateFrom, this.dateTo);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static ResourcesStage builder() {
    return new Builder();
  }

  public interface ResourcesStage {
    _FinalStage resources(String resources);

    Builder from(Filter other);
  }

  public interface _FinalStage {
    Filter build();

    _FinalStage dateFrom(Optional<String> dateFrom);

    _FinalStage dateFrom(String dateFrom);

    _FinalStage dateTo(Optional<String> dateTo);

    _FinalStage dateTo(String dateTo);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ResourcesStage, _FinalStage {
    private String resources;

    private Optional<String> dateTo = Optional.empty();

    private Optional<String> dateFrom = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(Filter other) {
      resources(other.getResources());
      dateFrom(other.getDateFrom());
      dateTo(other.getDateTo());
      return this;
    }

    /**
     * <p>Comma-separated list of resource types. If not specified on the
     * request, this will be <code>all</code>.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("resources")
    public _FinalStage resources(String resources) {
      this.resources = resources;
      return this;
    }

    /**
     * <p>The end date (inclusive) for which to filter returned resources -
     * formatted <code>YYYY-MM-DD</code> as per ISO 8601. If not provided,
     * no end date filter will be applied.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage dateTo(String dateTo) {
      this.dateTo = Optional.of(dateTo);
      return this;
    }

    @Override
    @JsonSetter(
        value = "dateTo",
        nulls = Nulls.SKIP
    )
    public _FinalStage dateTo(Optional<String> dateTo) {
      this.dateTo = dateTo;
      return this;
    }

    /**
     * <p>The start date (inclusive) for which to filter returned resources -
     * formatted <code>YYYY-MM-DD</code> as per ISO 8601. If not provided,
     * no start date filter will be applied.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage dateFrom(String dateFrom) {
      this.dateFrom = Optional.of(dateFrom);
      return this;
    }

    @Override
    @JsonSetter(
        value = "dateFrom",
        nulls = Nulls.SKIP
    )
    public _FinalStage dateFrom(Optional<String> dateFrom) {
      this.dateFrom = dateFrom;
      return this;
    }

    @Override
    public Filter build() {
      return new Filter(resources, dateFrom, dateTo, additionalProperties);
    }
  }
}