package id.co.wisnuprsj.librarymanagement.model.general;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@Accessors(chain = true)
public class BaseResponse<T> {

    @JsonIgnore
    private HttpStatus status;
    private int code;
    private String message;
    private T data;

    public boolean isOk() {
        return this.code == 200;
    }

    @JsonIgnore
    public BaseResponse setOk(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
        this.status = HttpStatus.OK;

        return this;
    }

    @JsonIgnore
    public BaseResponse setOk(T data, String message) {
        this.code = 200;
        this.message = message;
        this.data = data;
        this.status = HttpStatus.OK;

        return this;
    }

    @JsonIgnore
    public BaseResponse setError(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;
        this.status = status;
        return this;
    }

    @JsonIgnore
    public BaseResponse setFailed(String message) {
        this.code = 400;
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
        return this;
    }

}
