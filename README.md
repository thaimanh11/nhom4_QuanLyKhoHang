# Hướng dẫn cài đặt và sử dụng hệ thống quản lý kho hàng

### Chạy file JAR

**Lưu ý**: Bạn cần cài đặt **OpenJDK Platform** để khởi chạy ứng dụng.

### Cách cài đặt OpenJDK Platform (dành cho Windows):

1. Mở **Command Prompt**.
2. Nhập lệnh sau để cài đặt **Oracle Java Runtime Environment**:

   ```bash
   winget install Oracle.JavaRuntimeEnvironment
   ```

   Nhấn **Y** để xác nhận cài đặt.

3. Sau khi hệ thống hiện thông báo **install successfully**, nhập tiếp lệnh sau:
   ```bash
   winget install Oracle.JDK.23
   ```
4. Sau khi tải về, hệ thống sẽ tự động bắt đầu cài đặt. **Lưu ý**: Khi cài đặt, sẽ có các pop-up yêu cầu xác nhận. Hãy đồng ý để tiếp tục cài đặt.

5. Khi cài đặt hoàn tất và màn hình hiện thông báo **install successfully**, bạn cần **khởi động lại máy tính**.

6. Sau khi khởi động lại, bạn có thể chạy file JAR với **OpenJDK Platform**.

7. Tiến hành sử dụng phần mềm.

---
** tải source code ở link github : https://github.com/thaimanh11/nhom4_QuanLyKhoHang

### Đăng nhập hệ thống

1.  Đăng nhập hệ thống :
    mặc định với tài khoản :

- tài khoản : "admin"
- mật khẩu :"123"
2.  Sau khi đăng nhập bạn sẽ được điều hướng tới Menu:
- ở đây bạn có thể chọn : + thêm hàng để thêm mặt hàng 
                            + xem thông tin hàng hoá để kiểm tra thông tin các mặt hàng trong kho 
                            + xuất hàng để lựa chọn mặt hàng và số lượng cần xuất 
                            + thoát để thoát ứng dụng 
3. lựa chọn thêm hàng : 
- hãy nhập đầy đủ thông tin mặt hàng : tên hàng , loại hàng , số lượng , đơn giá , hạn sử dụng , nhà cung cấp
- ấn thêm để thêm mặt hàng vào kho 
- ấn thoát để thoát mục thêm hàng 
4. xem thông tin :
- tất cả các mặt hàng đã có trong kho đều hiện thị ở đây , tất cả các thông tin về mặt hàng .
- nhập vào thanh tìm kiếm tên hàng thì bạn sẽ tìm được mặt hàng mà bạn muốn xem và thông tin của nó 
5.  Xuất hàng 
- ở mục tên hàng , bạn hãy lựa chọn mặt hàng cần xuất , nó sẽ hiển thị số lượng và giá tiền của mặt hàng ở trong kho .
- sau đó nhập số lượng cần xuất ( yêu cầu nhập bé hơn hoặc bằng lượng hàng có ở trong kho , ko đúng yêu cầu nhập lại ) ấn xuất hàng để xuất lượng hàng khỏi kho .
- ấn thoát để thoát mục xuất hàng 


--- Cảm ơn mọi người đã xem project này , hãy để lại ý kiến và đánh giá để team có thể phát triển tốt hơn nhé ---

