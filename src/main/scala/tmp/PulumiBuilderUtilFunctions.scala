package tmp

import com.pulumi.Context
import com.pulumi.Pulumi
import com.pulumi.core.Output
import com.pulumi.resources.{CustomResourceOptions, Resource}
import scala.collection.JavaConverters._
import collection.convert.ImplicitConversionsToScala.`collection AsScalaIterable`
import scala.compiletime.ops.boolean
import scala.compiletime.ops.string
import scala.language.implicitConversions

type mapCustomerOwnedIpOnLaunchOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type routesOwners = com.pulumi.aws.ec2.RouteTableArgs.Builder
type availabilityZoneOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type egressOnlyGatewayIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type ipv6IpamPoolIdOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type cidrBlockOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder | com.pulumi.aws.ec2.SubnetArgs.Builder | com.pulumi.aws.ec2.VpcArgs.Builder
type destinationPrefixListIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type mapPublicIpOnLaunchOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type instanceIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type enableDnsSupportOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type assignIpv6AddressOnCreationOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type availabilityZoneIdOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type instanceTenancyOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type routeTableIdOwners = com.pulumi.aws.ec2.RouteTableAssociationArgs.Builder
type vpcIdOwners = com.pulumi.aws.ec2.InternetGatewayArgs.Builder | com.pulumi.aws.ec2.RouteTableArgs.Builder | com.pulumi.aws.ec2.SubnetArgs.Builder
type gatewayIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder | com.pulumi.aws.ec2.RouteTableAssociationArgs.Builder
type localGatewayIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type tagsOwners = com.pulumi.aws.ec2.InternetGatewayArgs.Builder | com.pulumi.aws.ec2.RouteTableArgs.Builder | com.pulumi.aws.ec2.SubnetArgs.Builder | com.pulumi.aws.ec2.VpcArgs.Builder
type privateDnsHostnameTypeOnLaunchOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type enableDns64Owners = com.pulumi.aws.ec2.SubnetArgs.Builder
type enableResourceNameDnsARecordOnLaunchOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type ipv4NetmaskLengthOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type enableNetworkAddressUsageMetricsOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type ipv6NetmaskLengthOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type carrierGatewayIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type subnetIdOwners = com.pulumi.aws.ec2.RouteTableAssociationArgs.Builder
type enableDnsHostnamesOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type coreNetworkArnOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type vpcPeeringConnectionIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type propagatingVgwsOwners = com.pulumi.aws.ec2.RouteTableArgs.Builder
type ipv6NativeOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type assignGeneratedIpv6CidrBlockOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type outpostArnOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type ipv6CidrBlockNetworkBorderGroupOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type natGatewayIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type enableClassiclinkDnsSupportOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type ipv6CidrBlockOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder | com.pulumi.aws.ec2.SubnetArgs.Builder | com.pulumi.aws.ec2.VpcArgs.Builder
type enableResourceNameDnsAaaaRecordOnLaunchOwners = com.pulumi.aws.ec2.SubnetArgs.Builder
type transitGatewayIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type networkInterfaceIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type vpcEndpointIdOwners = com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder
type ipv4IpamPoolIdOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type enableClassiclinkOwners = com.pulumi.aws.ec2.VpcArgs.Builder
type customerOwnedIpv4PoolOwners = com.pulumi.aws.ec2.SubnetArgs.Builder

implicit def convertScalaListToJavaList[A](scalaList: List[A]): java.util.List[A] =
	scalaList
	.asJava

implicit def convertScalaMapToJavaMap[A, B](scalaMap: Map[A, B]): java.util.Map[A, B] =
	scalaMap
	.asJava



def mapCustomerOwnedIpOnLaunch(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: mapCustomerOwnedIpOnLaunchOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.mapCustomerOwnedIpOnLaunch(x)
				case x: Output[java.lang.Boolean] => builder.mapCustomerOwnedIpOnLaunch(x)


def routes(param: List[com.pulumi.aws.ec2.inputs.RouteTableRouteArgs] | Output[java.util.List[com.pulumi.aws.ec2.inputs.RouteTableRouteArgs]])(using b: routesOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.RouteTableArgs.Builder =>
			param match
				case x: List[com.pulumi.aws.ec2.inputs.RouteTableRouteArgs] => builder.routes(x)
				case x: Output[java.util.List[com.pulumi.aws.ec2.inputs.RouteTableRouteArgs]] => builder.routes(x)


def availabilityZone(param: java.lang.String | Output[java.lang.String])(using b: availabilityZoneOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.String => builder.availabilityZone(x)
				case x: Output[java.lang.String] => builder.availabilityZone(x)


def egressOnlyGatewayId(param: java.lang.String | Output[java.lang.String])(using b: egressOnlyGatewayIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.egressOnlyGatewayId(x)
				case x: Output[java.lang.String] => builder.egressOnlyGatewayId(x)


def ipv6IpamPoolId(param: java.lang.String | Output[java.lang.String])(using b: ipv6IpamPoolIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.String => builder.ipv6IpamPoolId(x)
				case x: Output[java.lang.String] => builder.ipv6IpamPoolId(x)


def cidrBlock(param: java.lang.String | Output[java.lang.String])(using b: cidrBlockOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.cidrBlock(x)
				case x: Output[java.lang.String] => builder.cidrBlock(x)
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.String => builder.cidrBlock(x)
				case x: Output[java.lang.String] => builder.cidrBlock(x)
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.String => builder.cidrBlock(x)
				case x: Output[java.lang.String] => builder.cidrBlock(x)


def destinationPrefixListId(param: java.lang.String | Output[java.lang.String])(using b: destinationPrefixListIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.destinationPrefixListId(x)
				case x: Output[java.lang.String] => builder.destinationPrefixListId(x)


def mapPublicIpOnLaunch(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: mapPublicIpOnLaunchOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.mapPublicIpOnLaunch(x)
				case x: Output[java.lang.Boolean] => builder.mapPublicIpOnLaunch(x)


def instanceId(param: java.lang.String | Output[java.lang.String])(using b: instanceIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.instanceId(x)
				case x: Output[java.lang.String] => builder.instanceId(x)


def enableDnsSupport(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: enableDnsSupportOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.enableDnsSupport(x)
				case x: Output[java.lang.Boolean] => builder.enableDnsSupport(x)


def assignIpv6AddressOnCreation(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: assignIpv6AddressOnCreationOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.assignIpv6AddressOnCreation(x)
				case x: Output[java.lang.Boolean] => builder.assignIpv6AddressOnCreation(x)


def availabilityZoneId(param: java.lang.String | Output[java.lang.String])(using b: availabilityZoneIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.String => builder.availabilityZoneId(x)
				case x: Output[java.lang.String] => builder.availabilityZoneId(x)


def instanceTenancy(param: java.lang.String | Output[java.lang.String])(using b: instanceTenancyOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.String => builder.instanceTenancy(x)
				case x: Output[java.lang.String] => builder.instanceTenancy(x)


def routeTableId(param: java.lang.String | Output[java.lang.String])(using b: routeTableIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.RouteTableAssociationArgs.Builder =>
			param match
				case x: java.lang.String => builder.routeTableId(x)
				case x: Output[java.lang.String] => builder.routeTableId(x)


def vpcId(param: java.lang.String | Output[java.lang.String])(using b: vpcIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.InternetGatewayArgs.Builder =>
			param match
				case x: java.lang.String => builder.vpcId(x)
				case x: Output[java.lang.String] => builder.vpcId(x)
		case builder: com.pulumi.aws.ec2.RouteTableArgs.Builder =>
			param match
				case x: java.lang.String => builder.vpcId(x)
				case x: Output[java.lang.String] => builder.vpcId(x)
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.String => builder.vpcId(x)
				case x: Output[java.lang.String] => builder.vpcId(x)


def gatewayId(param: java.lang.String | Output[java.lang.String])(using b: gatewayIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.gatewayId(x)
				case x: Output[java.lang.String] => builder.gatewayId(x)
		case builder: com.pulumi.aws.ec2.RouteTableAssociationArgs.Builder =>
			param match
				case x: java.lang.String => builder.gatewayId(x)
				case x: Output[java.lang.String] => builder.gatewayId(x)


def localGatewayId(param: java.lang.String | Output[java.lang.String])(using b: localGatewayIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.localGatewayId(x)
				case x: Output[java.lang.String] => builder.localGatewayId(x)


def tags(param: Map[java.lang.String,java.lang.String] | Output[java.util.Map[java.lang.String,java.lang.String]])(using b: tagsOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.InternetGatewayArgs.Builder =>
			param match
				case x: Map[java.lang.String,java.lang.String] => builder.tags(x)
				case x: Output[java.util.Map[java.lang.String,java.lang.String]] => builder.tags(x)
		case builder: com.pulumi.aws.ec2.RouteTableArgs.Builder =>
			param match
				case x: Map[java.lang.String,java.lang.String] => builder.tags(x)
				case x: Output[java.util.Map[java.lang.String,java.lang.String]] => builder.tags(x)
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: Map[java.lang.String,java.lang.String] => builder.tags(x)
				case x: Output[java.util.Map[java.lang.String,java.lang.String]] => builder.tags(x)
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: Map[java.lang.String,java.lang.String] => builder.tags(x)
				case x: Output[java.util.Map[java.lang.String,java.lang.String]] => builder.tags(x)


def privateDnsHostnameTypeOnLaunch(param: java.lang.String | Output[java.lang.String])(using b: privateDnsHostnameTypeOnLaunchOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.String => builder.privateDnsHostnameTypeOnLaunch(x)
				case x: Output[java.lang.String] => builder.privateDnsHostnameTypeOnLaunch(x)


def enableDns64(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: enableDns64Owners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.enableDns64(x)
				case x: Output[java.lang.Boolean] => builder.enableDns64(x)


def enableResourceNameDnsARecordOnLaunch(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: enableResourceNameDnsARecordOnLaunchOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.enableResourceNameDnsARecordOnLaunch(x)
				case x: Output[java.lang.Boolean] => builder.enableResourceNameDnsARecordOnLaunch(x)


def ipv4NetmaskLength(param: java.lang.Integer | Output[java.lang.Integer])(using b: ipv4NetmaskLengthOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.Integer => builder.ipv4NetmaskLength(x)
				case x: Output[java.lang.Integer] => builder.ipv4NetmaskLength(x)


def enableNetworkAddressUsageMetrics(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: enableNetworkAddressUsageMetricsOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.enableNetworkAddressUsageMetrics(x)
				case x: Output[java.lang.Boolean] => builder.enableNetworkAddressUsageMetrics(x)


def ipv6NetmaskLength(param: java.lang.Integer | Output[java.lang.Integer])(using b: ipv6NetmaskLengthOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.Integer => builder.ipv6NetmaskLength(x)
				case x: Output[java.lang.Integer] => builder.ipv6NetmaskLength(x)


def carrierGatewayId(param: java.lang.String | Output[java.lang.String])(using b: carrierGatewayIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.carrierGatewayId(x)
				case x: Output[java.lang.String] => builder.carrierGatewayId(x)


def subnetId(param: java.lang.String | Output[java.lang.String])(using b: subnetIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.RouteTableAssociationArgs.Builder =>
			param match
				case x: java.lang.String => builder.subnetId(x)
				case x: Output[java.lang.String] => builder.subnetId(x)


def enableDnsHostnames(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: enableDnsHostnamesOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.enableDnsHostnames(x)
				case x: Output[java.lang.Boolean] => builder.enableDnsHostnames(x)


def coreNetworkArn(param: java.lang.String | Output[java.lang.String])(using b: coreNetworkArnOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.coreNetworkArn(x)
				case x: Output[java.lang.String] => builder.coreNetworkArn(x)


def vpcPeeringConnectionId(param: java.lang.String | Output[java.lang.String])(using b: vpcPeeringConnectionIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.vpcPeeringConnectionId(x)
				case x: Output[java.lang.String] => builder.vpcPeeringConnectionId(x)


def propagatingVgws(param: List[java.lang.String] | Output[java.util.List[java.lang.String]])(using b: propagatingVgwsOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.RouteTableArgs.Builder =>
			param match
				case x: List[java.lang.String] => builder.propagatingVgws(x)
				case x: Output[java.util.List[java.lang.String]] => builder.propagatingVgws(x)


def ipv6Native(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: ipv6NativeOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.ipv6Native(x)
				case x: Output[java.lang.Boolean] => builder.ipv6Native(x)


def assignGeneratedIpv6CidrBlock(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: assignGeneratedIpv6CidrBlockOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.assignGeneratedIpv6CidrBlock(x)
				case x: Output[java.lang.Boolean] => builder.assignGeneratedIpv6CidrBlock(x)


def outpostArn(param: java.lang.String | Output[java.lang.String])(using b: outpostArnOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.String => builder.outpostArn(x)
				case x: Output[java.lang.String] => builder.outpostArn(x)


def ipv6CidrBlockNetworkBorderGroup(param: java.lang.String | Output[java.lang.String])(using b: ipv6CidrBlockNetworkBorderGroupOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.String => builder.ipv6CidrBlockNetworkBorderGroup(x)
				case x: Output[java.lang.String] => builder.ipv6CidrBlockNetworkBorderGroup(x)


def natGatewayId(param: java.lang.String | Output[java.lang.String])(using b: natGatewayIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.natGatewayId(x)
				case x: Output[java.lang.String] => builder.natGatewayId(x)


def enableClassiclinkDnsSupport(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: enableClassiclinkDnsSupportOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.enableClassiclinkDnsSupport(x)
				case x: Output[java.lang.Boolean] => builder.enableClassiclinkDnsSupport(x)


def ipv6CidrBlock(param: java.lang.String | Output[java.lang.String])(using b: ipv6CidrBlockOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.ipv6CidrBlock(x)
				case x: Output[java.lang.String] => builder.ipv6CidrBlock(x)
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.String => builder.ipv6CidrBlock(x)
				case x: Output[java.lang.String] => builder.ipv6CidrBlock(x)
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.String => builder.ipv6CidrBlock(x)
				case x: Output[java.lang.String] => builder.ipv6CidrBlock(x)


def enableResourceNameDnsAaaaRecordOnLaunch(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: enableResourceNameDnsAaaaRecordOnLaunchOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.enableResourceNameDnsAaaaRecordOnLaunch(x)
				case x: Output[java.lang.Boolean] => builder.enableResourceNameDnsAaaaRecordOnLaunch(x)


def transitGatewayId(param: java.lang.String | Output[java.lang.String])(using b: transitGatewayIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.transitGatewayId(x)
				case x: Output[java.lang.String] => builder.transitGatewayId(x)


def networkInterfaceId(param: java.lang.String | Output[java.lang.String])(using b: networkInterfaceIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.networkInterfaceId(x)
				case x: Output[java.lang.String] => builder.networkInterfaceId(x)


def vpcEndpointId(param: java.lang.String | Output[java.lang.String])(using b: vpcEndpointIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.inputs.RouteTableRouteArgs.Builder =>
			param match
				case x: java.lang.String => builder.vpcEndpointId(x)
				case x: Output[java.lang.String] => builder.vpcEndpointId(x)


def ipv4IpamPoolId(param: java.lang.String | Output[java.lang.String])(using b: ipv4IpamPoolIdOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.String => builder.ipv4IpamPoolId(x)
				case x: Output[java.lang.String] => builder.ipv4IpamPoolId(x)


def enableClassiclink(param: java.lang.Boolean | Output[java.lang.Boolean])(using b: enableClassiclinkOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.VpcArgs.Builder =>
			param match
				case x: java.lang.Boolean => builder.enableClassiclink(x)
				case x: Output[java.lang.Boolean] => builder.enableClassiclink(x)


def customerOwnedIpv4Pool(param: java.lang.String | Output[java.lang.String])(using b: customerOwnedIpv4PoolOwners): Unit =
	b match
		case builder: com.pulumi.aws.ec2.SubnetArgs.Builder =>
			param match
				case x: java.lang.String => builder.customerOwnedIpv4Pool(x)
				case x: Output[java.lang.String] => builder.customerOwnedIpv4Pool(x)




