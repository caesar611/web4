package jx.pgz.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class A2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "xyz_campaign_id", type = IdType.AUTO)
    private Integer xyzCampaignId;

    private Integer approvedConversionTotal;

    private Integer clicksTotal;

    private Double ratio;


}
