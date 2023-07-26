package com.exlibris.dps.repository.plugin.formatidentification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "siegfried", "scandate", "signature", "created",
		"identifiers", "files" })
public class SiegfriedInfo {

	@JsonProperty("siegfried")
	private String siegfried;
	@JsonProperty("scandate")
	private String scandate;
	@JsonProperty("signature")
	private String signature;
	@JsonProperty("created")
	private String created;
	@JsonProperty("identifiers")
	private List<Identifier> identifiers = null;
	@JsonProperty("files")
	private List<File> files = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("siegfried")
	public String getSiegfried() {
		return siegfried;
	}

	@JsonProperty("siegfried")
	public void setSiegfried(String siegfried) {
		this.siegfried = siegfried;
	}

	@JsonProperty("scandate")
	public String getScandate() {
		return scandate;
	}

	@JsonProperty("scandate")
	public void setScandate(String scandate) {
		this.scandate = scandate;
	}

	@JsonProperty("signature")
	public String getSignature() {
		return signature;
	}

	@JsonProperty("signature")
	public void setSignature(String signature) {
		this.signature = signature;
	}

	@JsonProperty("created")
	public String getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(String created) {
		this.created = created;
	}

	@JsonProperty("identifiers")
	public List<Identifier> getIdentifiers() {
		return identifiers;
	}

	@JsonProperty("identifiers")
	public void setIdentifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
	}

	@JsonProperty("files")
	public List<File> getFiles() {
		return files;
	}

	@JsonProperty("files")
	public void setFiles(List<File> files) {
		this.files = files;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(SiegfriedInfo.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("siegfried");
		sb.append('=');
		sb.append(((this.siegfried == null) ? "<null>" : this.siegfried));
		sb.append(',');
		sb.append("scandate");
		sb.append('=');
		sb.append(((this.scandate == null) ? "<null>" : this.scandate));
		sb.append(',');
		sb.append("signature");
		sb.append('=');
		sb.append(((this.signature == null) ? "<null>" : this.signature));
		sb.append(',');
		sb.append("created");
		sb.append('=');
		sb.append(((this.created == null) ? "<null>" : this.created));
		sb.append(',');
		sb.append("identifiers");
		sb.append('=');
		sb.append(((this.identifiers == null) ? "<null>" : this.identifiers));
		sb.append(',');
		sb.append("files");
		sb.append('=');
		sb.append(((this.files == null) ? "<null>" : this.files));
		sb.append(',');
		sb.append("additionalProperties");
		sb.append('=');
		sb.append(((this.additionalProperties == null) ? "<null>"
				: this.additionalProperties));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "filename", "filesize", "modified", "errors",
			"matches" })
	public static class File {

		@JsonProperty("filename")
		private String filename;
		@JsonProperty("filesize")
		private Integer filesize;
		@JsonProperty("modified")
		private String modified;
		@JsonProperty("errors")
		private String errors;
		@JsonProperty("matches")
		private List<Match> matches = null;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("filename")
		public String getFilename() {
			return filename;
		}

		@JsonProperty("filename")
		public void setFilename(String filename) {
			this.filename = filename;
		}

		@JsonProperty("filesize")
		public Integer getFilesize() {
			return filesize;
		}

		@JsonProperty("filesize")
		public void setFilesize(Integer filesize) {
			this.filesize = filesize;
		}

		@JsonProperty("modified")
		public String getModified() {
			return modified;
		}

		@JsonProperty("modified")
		public void setModified(String modified) {
			this.modified = modified;
		}

		@JsonProperty("errors")
		public String getErrors() {
			return errors;
		}

		@JsonProperty("errors")
		public void setErrors(String errors) {
			this.errors = errors;
		}

		@JsonProperty("matches")
		public List<Match> getMatches() {
			return matches;
		}

		@JsonProperty("matches")
		public void setMatches(List<Match> matches) {
			this.matches = matches;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(File.class.getName()).append('@')
					.append(Integer.toHexString(System.identityHashCode(this)))
					.append('[');
			sb.append("filename");
			sb.append('=');
			sb.append(((this.filename == null) ? "<null>" : this.filename));
			sb.append(',');
			sb.append("filesize");
			sb.append('=');
			sb.append(((this.filesize == null) ? "<null>" : this.filesize));
			sb.append(',');
			sb.append("modified");
			sb.append('=');
			sb.append(((this.modified == null) ? "<null>" : this.modified));
			sb.append(',');
			sb.append("errors");
			sb.append('=');
			sb.append(((this.errors == null) ? "<null>" : this.errors));
			sb.append(',');
			sb.append("matches");
			sb.append('=');
			sb.append(((this.matches == null) ? "<null>" : this.matches));
			sb.append(',');
			sb.append("additionalProperties");
			sb.append('=');
			sb.append(((this.additionalProperties == null) ? "<null>"
					: this.additionalProperties));
			sb.append(',');
			if (sb.charAt((sb.length() - 1)) == ',') {
				sb.setCharAt((sb.length() - 1), ']');
			} else {
				sb.append(']');
			}
			return sb.toString();
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "name", "details" })
	public static class Identifier {

		@JsonProperty("name")
		private String name;
		@JsonProperty("details")
		private String details;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("name")
		public String getName() {
			return name;
		}

		@JsonProperty("name")
		public void setName(String name) {
			this.name = name;
		}

		@JsonProperty("details")
		public String getDetails() {
			return details;
		}

		@JsonProperty("details")
		public void setDetails(String details) {
			this.details = details;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(Identifier.class.getName()).append('@')
					.append(Integer.toHexString(System.identityHashCode(this)))
					.append('[');
			sb.append("name");
			sb.append('=');
			sb.append(((this.name == null) ? "<null>" : this.name));
			sb.append(',');
			sb.append("details");
			sb.append('=');
			sb.append(((this.details == null) ? "<null>" : this.details));
			sb.append(',');
			sb.append("additionalProperties");
			sb.append('=');
			sb.append(((this.additionalProperties == null) ? "<null>"
					: this.additionalProperties));
			sb.append(',');
			if (sb.charAt((sb.length() - 1)) == ',') {
				sb.setCharAt((sb.length() - 1), ']');
			} else {
				sb.append(']');
			}
			return sb.toString();
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "ns", "id", "format", "version", "mime", "basis",
			"warning" })
	public static class Match {

		@JsonProperty("ns")
		private String ns;
		@JsonProperty("id")
		private String id;
		@JsonProperty("format")
		private String format;
		@JsonProperty("version")
		private String version;
		@JsonProperty("mime")
		private String mime;
		@JsonProperty("basis")
		private String basis;
		@JsonProperty("warning")
		private String warning;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("ns")
		public String getNs() {
			return ns;
		}

		@JsonProperty("ns")
		public void setNs(String ns) {
			this.ns = ns;
		}

		@JsonProperty("id")
		public String getId() {
			return id;
		}

		@JsonProperty("id")
		public void setId(String id) {
			this.id = id;
		}

		@JsonProperty("format")
		public String getFormat() {
			return format;
		}

		@JsonProperty("format")
		public void setFormat(String format) {
			this.format = format;
		}

		@JsonProperty("version")
		public String getVersion() {
			return version;
		}

		@JsonProperty("version")
		public void setVersion(String version) {
			this.version = version;
		}

		@JsonProperty("mime")
		public String getMime() {
			return mime;
		}

		@JsonProperty("mime")
		public void setMime(String mime) {
			this.mime = mime;
		}

		@JsonProperty("basis")
		public String getBasis() {
			return basis;
		}

		@JsonProperty("basis")
		public void setBasis(String basis) {
			this.basis = basis;
		}

		@JsonProperty("warning")
		public String getWarning() {
			return warning;
		}

		@JsonProperty("warning")
		public void setWarning(String warning) {
			this.warning = warning;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(Match.class.getName()).append('@')
					.append(Integer.toHexString(System.identityHashCode(this)))
					.append('[');
			sb.append("ns");
			sb.append('=');
			sb.append(((this.ns == null) ? "<null>" : this.ns));
			sb.append(',');
			sb.append("id");
			sb.append('=');
			sb.append(((this.id == null) ? "<null>" : this.id));
			sb.append(',');
			sb.append("format");
			sb.append('=');
			sb.append(((this.format == null) ? "<null>" : this.format));
			sb.append(',');
			sb.append("version");
			sb.append('=');
			sb.append(((this.version == null) ? "<null>" : this.version));
			sb.append(',');
			sb.append("mime");
			sb.append('=');
			sb.append(((this.mime == null) ? "<null>" : this.mime));
			sb.append(',');
			sb.append("basis");
			sb.append('=');
			sb.append(((this.basis == null) ? "<null>" : this.basis));
			sb.append(',');
			sb.append("warning");
			sb.append('=');
			sb.append(((this.warning == null) ? "<null>" : this.warning));
			sb.append(',');
			sb.append("additionalProperties");
			sb.append('=');
			sb.append(((this.additionalProperties == null) ? "<null>"
					: this.additionalProperties));
			sb.append(',');
			if (sb.charAt((sb.length() - 1)) == ',') {
				sb.setCharAt((sb.length() - 1), ']');
			} else {
				sb.append(']');
			}
			return sb.toString();
		}
	}
}