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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = StartConsolidatedQueryResponse.Builder.class
)
public final class StartConsolidatedQueryResponse {
  private final PatientConsolidatedDataStatus status;

  private final Map<String, Object> additionalProperties;

  private StartConsolidatedQueryResponse(PatientConsolidatedDataStatus status,
      Map<String, Object> additionalProperties) {
    this.status = status;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("status")
  public PatientConsolidatedDataStatus getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof StartConsolidatedQueryResponse && equalTo((StartConsolidatedQueryResponse) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(StartConsolidatedQueryResponse other) {
    return status.equals(other.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.status);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static StatusStage builder() {
    return new Builder();
  }

  public interface StatusStage {
    _FinalStage status(PatientConsolidatedDataStatus status);

    Builder from(StartConsolidatedQueryResponse other);
  }

  public interface _FinalStage {
    StartConsolidatedQueryResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements StatusStage, _FinalStage {
    private PatientConsolidatedDataStatus status;

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(StartConsolidatedQueryResponse other) {
      status(other.getStatus());
      return this;
    }

    @Override
    @JsonSetter("status")
    public _FinalStage status(PatientConsolidatedDataStatus status) {
      this.status = status;
      return this;
    }

    @Override
    public StartConsolidatedQueryResponse build() {
      return new StartConsolidatedQueryResponse(status, additionalProperties);
    }
  }
}