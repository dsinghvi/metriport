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
    builder = GetConsolidatedQueryStatusResponse.Builder.class
)
public final class GetConsolidatedQueryStatusResponse {
  private final PatientConsolidatedDataStatus status;

  private final Optional<String> message;

  private final Map<String, Object> additionalProperties;

  private GetConsolidatedQueryStatusResponse(PatientConsolidatedDataStatus status,
      Optional<String> message, Map<String, Object> additionalProperties) {
    this.status = status;
    this.message = message;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("status")
  public PatientConsolidatedDataStatus getStatus() {
    return status;
  }

  @JsonProperty("message")
  public Optional<String> getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetConsolidatedQueryStatusResponse && equalTo((GetConsolidatedQueryStatusResponse) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(GetConsolidatedQueryStatusResponse other) {
    return status.equals(other.status) && message.equals(other.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.status, this.message);
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

    Builder from(GetConsolidatedQueryStatusResponse other);
  }

  public interface _FinalStage {
    GetConsolidatedQueryStatusResponse build();

    _FinalStage message(Optional<String> message);

    _FinalStage message(String message);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements StatusStage, _FinalStage {
    private PatientConsolidatedDataStatus status;

    private Optional<String> message = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(GetConsolidatedQueryStatusResponse other) {
      status(other.getStatus());
      message(other.getMessage());
      return this;
    }

    @Override
    @JsonSetter("status")
    public _FinalStage status(PatientConsolidatedDataStatus status) {
      this.status = status;
      return this;
    }

    @Override
    public _FinalStage message(String message) {
      this.message = Optional.of(message);
      return this;
    }

    @Override
    @JsonSetter(
        value = "message",
        nulls = Nulls.SKIP
    )
    public _FinalStage message(Optional<String> message) {
      this.message = message;
      return this;
    }

    @Override
    public GetConsolidatedQueryStatusResponse build() {
      return new GetConsolidatedQueryStatusResponse(status, message, additionalProperties);
    }
  }
}