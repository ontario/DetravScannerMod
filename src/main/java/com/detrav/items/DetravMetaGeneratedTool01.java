package com.detrav.items;

import com.detrav.DetravScannerMod;
import com.detrav.enums.DetravToolDictNames;
import com.detrav.items.tools.*;
import com.detrav.utils.DetravCreativeTab;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.interfaces.IToolStats;
import gregtech.api.items.GT_MetaGenerated_Tool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

/**
 * Created by wital_000 on 19.03.2016.
 */
public class DetravMetaGeneratedTool01 extends GT_MetaGenerated_Tool {
    public static DetravMetaGeneratedTool01 INSTANCE;

    public DetravMetaGeneratedTool01() {
        super("detrav.metatool.01");
        INSTANCE = this;
        addTool(0, "Prospector's Pick", "", new DetravToolProPick(), new Object[]{DetravToolDictNames.craftingToolProPick, new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4L)});
        addTool(2, "Portable Anvil", "", new DetravToolPortableAnvil(), new Object[] {DetravToolDictNames.craftingToolPortableAnvil}, new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM,10));
        addTool(4, "Smart plunger 1 bucket", "", new DetravToolSmartPlunger(),new Object[] {DetravToolDictNames.craftingToolSmartPlunger},new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 8L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L));
        addTool(6, "Smart plunger 16 buckets", "", new DetravToolSmartPlunger16(),new Object[] {DetravToolDictNames.craftingToolSmartPlunger},new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 8L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L));
        addTool(8, "Smart plunger 64 buckets", "", new DetravToolSmartPlunger64(),new Object[] {DetravToolDictNames.craftingToolSmartPlunger},new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 8L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 5L));
        addTool(10, "Smart Tree Tap","Changes resin tap",new DetravToolSmartTreeTap(),new Object[] {DetravToolDictNames.craftingToolSmartTreeTap}, new TC_Aspects.TC_AspectStack(TC_Aspects.ARBOR, 5L) );
        addTool(100, "Electric Prospector's Scanner (LV)", "", new DetravToolLVElectricProPick(), new Object[]{DetravToolDictNames.craftingToolElectricProPick, new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4L)}, new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 4L));
        addTool(102, "Electric Prospector's Scanner (MV)", "", new DetravToolMVElectricProPick(), new Object[]{DetravToolDictNames.craftingToolElectricProPick, new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4L)}, new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 4L));
        addTool(104, "Electric Prospector's Scanner (HV)", "", new DetravToolHVElectricProPick(), new Object[]{DetravToolDictNames.craftingToolElectricProPick, new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.METALLUM, 4L)}, new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 4L));
        addTool(106, "Portable Battery Charger", "", new DetravToolPortableCharger(), new Object[]{DetravToolDictNames.craftingToolPortableCharger, new TC_Aspects.TC_AspectStack(TC_Aspects.INSTRUMENTUM, 2L), new TC_Aspects.TC_AspectStack(TC_Aspects.AURAM, 4L)}, new TC_Aspects.TC_AspectStack(TC_Aspects.ELECTRUM, 4L));
        addTool(108, "Circuit Confugurator", "", new DetravToolCircuitConfigurator(), new Object[]{DetravToolDictNames.craftingToolCictuitConfigurator, new TC_Aspects.TC_AspectStack(TC_Aspects.COGNITIO,10L) });

        setCreativeTab(DetravScannerMod.TAB_DETRAV);
    }


    public void addAdditionalToolTips(List aList, ItemStack aStack, EntityPlayer aPlayer) {
        //getElectricStats()
        //super.addAdditionalToolTips();
        long tMaxDamage = getToolMaxDamage(aStack);
        Materials tMaterial = getPrimaryMaterial(aStack);
        IToolStats tStats = getToolStats(aStack);
        int tOffset = aList.size(); //getElectricStats(aStack) != null ? 2 : 1;
        if (tStats != null) {
            String name = aStack.getUnlocalizedName();
            String num = name.substring("gt.detrav.metatool.01.".length());
            int meta = Integer.parseInt(num);
            switch (meta) {
                case 0:
                    aList.add(tOffset + 0, EnumChatFormatting.WHITE + "Durability: " + EnumChatFormatting.GREEN + (tMaxDamage - getToolDamage(aStack)) + " / " + tMaxDamage + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 1, EnumChatFormatting.WHITE + tMaterial.mDefaultLocalName + EnumChatFormatting.YELLOW + " lvl " + getHarvestLevel(aStack, "") + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 2, "Right click on rock for prospecting current chunk!");
                    aList.add(tOffset + 3, "Right click on bedrock for prospecting oil!");
                    aList.add(tOffset + 4, "Traces: 1-9");
                    aList.add(tOffset + 5, "Small: 10-29");
                    aList.add(tOffset + 6, "Medium: 30-59");
                    aList.add(tOffset + 7, "Large: 60-99");
                    aList.add(tOffset + 8, "Very large: 100-***");
                    break;
                case 2:
                    int count;
                    count = ((int)(getLevel(aStack,0)*100)); if(count > 0) {aList.add(tOffset, "Bonus 0 level: +" + count + "%");tOffset++;}
                    count = ((int)(getLevel(aStack,1)*100)); if(count > 0) {aList.add(tOffset, "Bonus 1 level: +" + count + "%");tOffset++;}
                    count = ((int)(getLevel(aStack,2)*100)); if(count > 0) {aList.add(tOffset, "Bonus 2 level: +" + count + "%");tOffset++;}
                    count = ((int)(getLevel(aStack,3)*100)); if(count > 0) {aList.add(tOffset, "Bonus 3 level: +" + count + "%");tOffset++;}
                    count = ((int)(getLevel(aStack,4)*100)); if(count > 0) {aList.add(tOffset, "Bonus 4 level: +" + count + "%");tOffset++;}
                    count = ((int)(getLevel(aStack,5)*100)); if(count > 0) {aList.add(tOffset, "Bonus 5 level: +" + count + "%");tOffset++;}
                    count = ((int)(getLevel(aStack,6)*100)); if(count > 0) {aList.add(tOffset, "Bonus 6 level: +" + count + "%");tOffset++;}
                    count = ((int)(getLevel(aStack,7)*100)); if(count > 0) {aList.add(tOffset, "Bonus 7 level: +" + count + "%");tOffset++;}
                    count = ((int)(getLevel(aStack,8)*100)); if(count > 0) {aList.add(tOffset, "Bonus 8 level: +" + count + "%");tOffset++;}
                    break;
                case 4:
                case 6:
                case 8:
                    aList.add(tOffset + 0, EnumChatFormatting.WHITE + "Durability: " + EnumChatFormatting.GREEN + (tMaxDamage - getToolDamage(aStack)) + " / " + tMaxDamage + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 1, EnumChatFormatting.WHITE + tMaterial.mDefaultLocalName + EnumChatFormatting.YELLOW + " lvl " + getHarvestLevel(aStack, "") + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 2, "It can suck in fluid");
                    FluidStack stack = getFluidStackFromDetravData(aStack);
                    if(stack!=null && stack.amount >0)
                    {
                        aList.add(tOffset +3, "Fluid: "+stack.getLocalizedName()+" : "+stack.amount);
                    }
                    else
                    {
                        aList.add(tOffset +3, "Fluid: empty");
                    }
                    break;
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    aList.add(tOffset + 0, EnumChatFormatting.WHITE + "Durability: " + EnumChatFormatting.GREEN + (tMaxDamage - getToolDamage(aStack)) + " / " + tMaxDamage + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 1, EnumChatFormatting.WHITE + tMaterial.mDefaultLocalName + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 2, EnumChatFormatting.WHITE + "Chunks: " + EnumChatFormatting.YELLOW + (getHarvestLevel(aStack, "") * 2 + 1) + "x" + (getHarvestLevel(aStack, "") * 2 + 1) + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 3, "Right click on rock for prospecting current chunk!");
                    aList.add(tOffset + 4, "Right click on bedrock for prospecting oil!");
                    aList.add(tOffset + 5, "Right click for scanning!");
                    break;
                case 106:
                case 107:
                    aList.add(tOffset + 0, EnumChatFormatting.WHITE + "Loss/Tick EU: " + EnumChatFormatting.GREEN + getElectricStatsLoss(aStack) + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 1, EnumChatFormatting.WHITE + "Durability: " + EnumChatFormatting.GREEN + (tMaxDamage - getToolDamage(aStack)) + " / " + tMaxDamage + EnumChatFormatting.GRAY);
                    aList.add(tOffset + 2, "Can use as normal battery");
                    aList.add(tOffset + 3, "x4 charge speed for tools");
                    aList.add(tOffset + 4, "Right click to open GUI");
                    break;
                case 108:
                    aList.add(tOffset + 0, EnumChatFormatting.WHITE + "It can configure any programmed circuit" + EnumChatFormatting.GRAY);
                    break;
            }
        }
    }

    public Long getElectricStatsLoss(ItemStack aStack) {
        NBTTagCompound aNBT = aStack.getTagCompound();
        if (aNBT != null) {
            aNBT = aNBT.getCompoundTag("GT.ToolStats");
            if (aNBT != null && aNBT.getBoolean("Electric"))
                return aNBT.getLong("Loss");
        }
        return 0L;
    }

    public final ItemStack getToolWithStatsPlus(int aToolID, int aAmount, Materials aPrimaryMaterial, Materials aSecondaryMaterial, long[] aElectricArray, long aLoss) {
        return getToolWithStatsPlus(aToolID, aAmount, aPrimaryMaterial, aSecondaryMaterial, aElectricArray, aLoss, 10000L);
    }

    public final ItemStack getToolWithStatsPlus(int aToolID, int aAmount, Materials aPrimaryMaterial, Materials aSecondaryMaterial, long[] aElectricArray, long aLoss, long durability) {
        ItemStack result = getToolWithStats(aToolID, aAmount, aPrimaryMaterial, aSecondaryMaterial, aElectricArray);
        NBTTagCompound aNBT = result.getTagCompound();
        if (aNBT != null) {
            aNBT = aNBT.getCompoundTag("GT.ToolStats");
            if (aNBT != null && aNBT.getBoolean("Electric")) {
                aNBT.setLong("Loss", aLoss);
            }
            aNBT.setLong("MaxDamage", durability);
        }
        return result;
    }

    public Long getToolGTDetravData(ItemStack aStack) {
        NBTTagCompound aNBT = aStack.getTagCompound();
        if (aNBT != null) {
            aNBT = aNBT.getCompoundTag("GT.ToolStats");
            if (aNBT != null)
                return aNBT.getLong("DetravData");
        }
        return 0L;
    }

    public boolean setToolGTDetravData(ItemStack aStack, long data) {
        NBTTagCompound aNBT = aStack.getTagCompound();
        if (aNBT != null) {
            aNBT = aNBT.getCompoundTag("GT.ToolStats");
            if (aNBT != null) {
                aNBT.setLong("DetravData", data);
                return true;
            }
        }
        return false;
    }

    public void setLevelToItemStack(ItemStack aStack, int level, float percent)
    {
        if(aStack == null) return;
        NBTTagCompound aNBT = aStack.getTagCompound();
        if(aNBT == null) {
            aNBT = new NBTTagCompound();
            NBTTagCompound detravLevel = new NBTTagCompound();
            aNBT.setTag("DetravLevel", detravLevel);
            aStack.setTagCompound(aNBT);
        }
        {
            NBTTagCompound detravLevel = aNBT.getCompoundTag("DetravLevel");
            if (detravLevel == null || hasnolevel(detravLevel)) {
                detravLevel = new NBTTagCompound();
                aNBT.setTag("DetravLevel", detravLevel);
            }
            detravLevel.setFloat("level"+Integer.toString(level),percent);
        }
    }


    private boolean hasnolevel(NBTTagCompound detravLevel)
    {
        for(int i=0;i<9;i++)
        {
            if(detravLevel.hasKey("level"+Integer.toString(i)))
              return false;
        }
        return true;
    }

    public float getLevel(ItemStack aStack, int level)
    {
        if(aStack == null) return 0;
        NBTTagCompound aNBT = aStack.getTagCompound();
        if(aNBT ==null) return 0;
        NBTTagCompound detravLevel = aNBT.getCompoundTag("DetravLevel");
        if(detravLevel == null) return 0;
        return detravLevel.getFloat("level"+Integer.toString(level));
    }

    public boolean setItemStackToDetravData(ItemStack aStack, ItemStack what)
    {
        if(aStack == null) return false;
        NBTTagCompound aNBT = aStack.getTagCompound();
        if(aNBT == null) {
            aNBT = new NBTTagCompound();
            NBTTagCompound detravData = new NBTTagCompound();
            aNBT.setTag("DetravData", detravData);
            aStack.setTagCompound(aNBT);
        }
        {
            NBTTagCompound detravData = aNBT.getCompoundTag("DetravData");
            if (detravData == null || detravData.getShort("id") == 0) {
                detravData = new NBTTagCompound();
                aNBT.setTag("DetravData", detravData);
            }
            if (what == null)
                aNBT.removeTag("DetravData");
            else
                what.writeToNBT(detravData);
            return true;
        }
    }

    public ItemStack getItemStackFromDetravData(ItemStack aStack)
    {
        if(aStack == null) return null;
        NBTTagCompound aNBT = aStack.getTagCompound();
        if(aNBT ==null) return null;
        NBTTagCompound detravData = aNBT.getCompoundTag("DetravData");
        if(detravData == null) return null;
        return ItemStack.loadItemStackFromNBT(detravData);
    }


    public boolean setFluidStackToDetravData(ItemStack aStack, FluidStack what)
    {
        if(aStack == null) return false;
        NBTTagCompound aNBT = aStack.getTagCompound();
        if(aNBT == null) {
            aNBT = new NBTTagCompound();
            NBTTagCompound detravData = new NBTTagCompound();
            aNBT.setTag("DetravData", detravData);
            aStack.setTagCompound(aNBT);
        }
        {
            NBTTagCompound detravData = aNBT.getCompoundTag("DetravData");
            if (detravData == null || detravData.getShort("id") == 0) {
                detravData = new NBTTagCompound();
                aNBT.setTag("DetravData", detravData);
            }
            if (what == null)
                aNBT.removeTag("DetravData");
            else
                what.writeToNBT(detravData);
            return true;
        }
    }

    public FluidStack getFluidStackFromDetravData(ItemStack aStack)
    {
        if(aStack == null) return null;
        NBTTagCompound aNBT = aStack.getTagCompound();
        if(aNBT ==null) return null;
        NBTTagCompound detravData = aNBT.getCompoundTag("DetravData");
        if(detravData == null) return null;
        return FluidStack.loadFluidStackFromNBT(detravData);
    }

    public void getDetravSubItems(Item item, CreativeTabs detravCreativeTab, List list) {

        ItemStack dStack;

        dStack = getToolWithStatsPlus(106, 1, Materials.Tin, Materials.StainlessSteel, new long[]{4 * 100000L, 32L, 1L, -3L}, 1);
        setCharge(dStack,4 * 100000L);
        list.add(dStack);
        dStack = getToolWithStatsPlus(106, 1, Materials.Tin, Materials.StainlessSteel, new long[]{4 * 75000L, 32L, 1L, -3L}, 1);
        setCharge(dStack,4 * 75000L);
        list.add(dStack);
        dStack = getToolWithStatsPlus(106, 1, Materials.Tin, Materials.StainlessSteel, new long[]{4 * 50000L, 32L, 1L, -3L}, 1);
        setCharge(dStack,4 * 50000L);
        list.add(dStack);
        dStack = getToolWithStatsPlus(106, 1, Materials.AnnealedCopper, Materials.Titanium, new long[]{4 * 400000L, 128L, 2L, -3L}, 1);
        setCharge(dStack,4 * 400000L);
        list.add(dStack);
        dStack = getToolWithStatsPlus(106, 1, Materials.AnnealedCopper, Materials.Titanium, new long[]{4 * 300000L, 128L, 2L, -3L}, 1);
        setCharge(dStack,4 * 300000L);
        list.add(dStack);
        dStack = getToolWithStatsPlus(106, 1, Materials.AnnealedCopper, Materials.Titanium, new long[]{4 * 200000L, 128L, 2L, -3L}, 1);
        setCharge(dStack,4 * 200000L);
        list.add(dStack);
        dStack = getToolWithStatsPlus(106, 1, Materials.Silver, Materials.TungstenSteel, new long[]{4 * 1600000L, 512L, 3L, -3L}, 1);
        setCharge(dStack,4 * 1600000L);
        list.add(dStack);
        dStack = getToolWithStatsPlus(106, 1, Materials.Silver, Materials.TungstenSteel, new long[]{4 * 1200000L, 512L, 3L, -3L}, 1);
        setCharge(dStack,4 * 1200000L);
        list.add(dStack);
        dStack = getToolWithStatsPlus(106, 1, Materials.Silver, Materials.TungstenSteel, new long[]{4 * 800000L, 512L, 3L, -3L}, 1);
        setCharge(dStack,4 * 800000L);
        list.add(dStack);

        dStack = getToolWithStats(104, 1, Materials.Neutronium, Materials.TungstenSteel, new long[]{1600000L, 512L, 3L, -1L});
        setCharge(dStack,1600000L);
        list.add(dStack);

    }
}