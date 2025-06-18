package com.sia.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 订单号
     */
    private String number;

    /**
     * 订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 7退款
     */
    private Integer status;

    /**
     * 下单用户
     */
    private String userId;

    /**
     * 地址id
     */
    private String addressBookId;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;

    /**
     * 结账时间
     */
    private LocalDateTime checkoutTime;

    /**
     * 支付方式 1微信,2支付宝
     */
    private Integer payMethod;

    /**
     * 支付状态 0未支付 1已支付 2退款
     */
    private Integer payStatus;

    /**
     * 实收金额
     */
    private BigDecimal amount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 订单取消原因
     */
    private String cancelReason;

    /**
     * 订单拒绝原因
     */
    private String rejectionReason;

    /**
     * 订单取消时间
     */
    private Date cancelTime;

    /**
     * 预计送达时间
     */
    private Date estimatedDeliveryTime;

    /**
     * 配送状态  1立即送出  0选择具体时间
     */
    private Integer deliveryStatus;

    /**
     * 送达时间
     */
    private Date deliveryTime;

    /**
     * 打包费
     */
    private Integer packAmount;

    /**
     * 餐具数量
     */
    private Integer tablewareNumber;

    /**
     * 餐具数量状态  1按餐量提供  0选择具体数量
     */
    private Integer tablewareStatus;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Orders other = (Orders) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAddressBookId() == null ? other.getAddressBookId() == null : this.getAddressBookId().equals(other.getAddressBookId()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getCheckoutTime() == null ? other.getCheckoutTime() == null : this.getCheckoutTime().equals(other.getCheckoutTime()))
            && (this.getPayMethod() == null ? other.getPayMethod() == null : this.getPayMethod().equals(other.getPayMethod()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getConsignee() == null ? other.getConsignee() == null : this.getConsignee().equals(other.getConsignee()))
            && (this.getCancelReason() == null ? other.getCancelReason() == null : this.getCancelReason().equals(other.getCancelReason()))
            && (this.getRejectionReason() == null ? other.getRejectionReason() == null : this.getRejectionReason().equals(other.getRejectionReason()))
            && (this.getCancelTime() == null ? other.getCancelTime() == null : this.getCancelTime().equals(other.getCancelTime()))
            && (this.getEstimatedDeliveryTime() == null ? other.getEstimatedDeliveryTime() == null : this.getEstimatedDeliveryTime().equals(other.getEstimatedDeliveryTime()))
            && (this.getDeliveryStatus() == null ? other.getDeliveryStatus() == null : this.getDeliveryStatus().equals(other.getDeliveryStatus()))
            && (this.getDeliveryTime() == null ? other.getDeliveryTime() == null : this.getDeliveryTime().equals(other.getDeliveryTime()))
            && (this.getPackAmount() == null ? other.getPackAmount() == null : this.getPackAmount().equals(other.getPackAmount()))
            && (this.getTablewareNumber() == null ? other.getTablewareNumber() == null : this.getTablewareNumber().equals(other.getTablewareNumber()))
            && (this.getTablewareStatus() == null ? other.getTablewareStatus() == null : this.getTablewareStatus().equals(other.getTablewareStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAddressBookId() == null) ? 0 : getAddressBookId().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getCheckoutTime() == null) ? 0 : getCheckoutTime().hashCode());
        result = prime * result + ((getPayMethod() == null) ? 0 : getPayMethod().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getConsignee() == null) ? 0 : getConsignee().hashCode());
        result = prime * result + ((getCancelReason() == null) ? 0 : getCancelReason().hashCode());
        result = prime * result + ((getRejectionReason() == null) ? 0 : getRejectionReason().hashCode());
        result = prime * result + ((getCancelTime() == null) ? 0 : getCancelTime().hashCode());
        result = prime * result + ((getEstimatedDeliveryTime() == null) ? 0 : getEstimatedDeliveryTime().hashCode());
        result = prime * result + ((getDeliveryStatus() == null) ? 0 : getDeliveryStatus().hashCode());
        result = prime * result + ((getDeliveryTime() == null) ? 0 : getDeliveryTime().hashCode());
        result = prime * result + ((getPackAmount() == null) ? 0 : getPackAmount().hashCode());
        result = prime * result + ((getTablewareNumber() == null) ? 0 : getTablewareNumber().hashCode());
        result = prime * result + ((getTablewareStatus() == null) ? 0 : getTablewareStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
        sb.append(", addressBookId=").append(addressBookId);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", checkoutTime=").append(checkoutTime);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", amount=").append(amount);
        sb.append(", remark=").append(remark);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", userName=").append(userName);
        sb.append(", consignee=").append(consignee);
        sb.append(", cancelReason=").append(cancelReason);
        sb.append(", rejectionReason=").append(rejectionReason);
        sb.append(", cancelTime=").append(cancelTime);
        sb.append(", estimatedDeliveryTime=").append(estimatedDeliveryTime);
        sb.append(", deliveryStatus=").append(deliveryStatus);
        sb.append(", deliveryTime=").append(deliveryTime);
        sb.append(", packAmount=").append(packAmount);
        sb.append(", tablewareNumber=").append(tablewareNumber);
        sb.append(", tablewareStatus=").append(tablewareStatus);
        sb.append("]");
        return sb.toString();
    }
}